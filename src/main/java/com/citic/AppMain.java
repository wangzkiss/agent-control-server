package com.citic;

import com.citic.control.ProcessMonitor;
import com.citic.entity.MyExceptionMapper;
import com.citic.helper.SimpleKafkaProducer;
import com.citic.service.ConfigurationService;
import com.citic.service.ExeService;
import io.netty.channel.Channel;
import org.apache.commons.lang.BooleanUtils;
import org.glassfish.jersey.netty.httpserver.NettyHttpContainerProvider;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;

import static com.citic.AppConstants.KAFKA_USE_AVRO;


/**
 * AppMain class.
 */
public class AppMain {
    private static final Logger LOGGER = LoggerFactory.getLogger(AppMain.class);
    private static Channel server;
    private static SimpleKafkaProducer<Object, Object>  producer;
    private static ProcessMonitor processMonitor;

    public static void start() {
        String baseUri = AppConf.getConfig(AppConstants.AGENT_BASE_URI);
        boolean useAvro = BooleanUtils.toBoolean(AppConf.getConfig(KAFKA_USE_AVRO));

        URI BASE_URI = URI.create(baseUri);

        ResourceConfig resourceConfig = new ResourceConfig(
                ConfigurationService.class,
                ExeService.class,
                MyExceptionMapper.class
        );

        server = NettyHttpContainerProvider.createHttp2Server(BASE_URI, resourceConfig, null);

        LOGGER.info("Jersey App on Netty Server starting: {}", BASE_URI.toString());

        producer = new SimpleKafkaProducer<>(false, useAvro);
        // 启动对进程的监控
        processMonitor = new ProcessMonitor(producer, useAvro);
        processMonitor.start();
        
        Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            @Override
            public void run() {
                stop();
            }
        }));

        try {
            Thread.currentThread().join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void stop() {
        processMonitor.stop();
        producer.close();
        server.close();
    }

    public static void main(String[] args) {
        start();
    }
}

