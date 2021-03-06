package com.citic;

// avro 格式序列化类

public class AppConstants {

    private AppConstants() {
        throw new IllegalStateException("AppConstants class");
    }

    public static final String CLASSPATH_URL_PREFIX = "classpath:";

    public static final boolean STATE_ALIVE = true;
    public static final boolean STATE_DEAD = false;

    public static final String AGENT_BASE_URI = "agent.base.uri";
    public static final String AGENT_IP_INTERFACE = "agent.metrics.ip.interface";
    public static final String AGENT_VELOCITY_LOG = "agent.velocity.log";

    // cmd
    public static final String CANAL_HOME_DIR = "canal.home.dir";
    public static final String CANAL_START_CMD = "canal.start.cmd";
    public static final String CANAL_STOP_CMD = "canal.stop.cmd";

    public static final String CANAL_PSWD_ENCRYPT = "canal.passwd.encrypt";
    public static final boolean DEFAULT_CANAL_PASSWD_ENCRYPT = true;

    // conf
    public static final String CANAL_CONF_DIR = "canal.conf.dir";
    public static final String CANAL_LOGS_DIR = "canal.logs.dir";
    public static final String CANAL_SERVER_TEMPLATE = "canal.server.template";
    public static final String CANAL_INSTANCE_TEMPLATE = "canal.instance.template";


    public static final String TAGENT_HOME_DIR = "tagent.home.dir";
    public static final String TAGENT_START_CMD = "tagent.start.cmd";
    public static final String TAGENT_STOP_CMD = "tagent.stop.cmd";

    public static final String TAGENT_TEMPLATE = "tagent.template";
    public static final String TAGENT_CONF = "tagent.conf";

    public static final String TAGENT_LOG_FILE_PATH = "tagent.logfile.path";


    // monitor
    public static final String PROCESS_MONITOR_INTERVAL = "process.monitor.interval";

    public static final String CANAL_MONITOR_CMD = "canal.monitor.cmd";
    public static final String TAGENT_MONITOR_CMD = "tagent.monitor.cmd";

    public static final String CANAL_PROCESS_NAME = "Canal";
    public static final String TAGENT_PROCESS_NAME = "TAgent";

    public static final String KAFKA_AVRO_SERIALIZER =
        "io.confluent.kafka.serializers.KafkaAvroSerializer";

    public static final String DEFAULT_KEY_SERIALIZER =
        "org.apache.kafka.common.serialization.StringSerializer";
    public static final String DEFAULT_VALUE_SERIAIZER =
        "org.apache.kafka.common.serialization.ByteArraySerializer";

    public static final String SCHEMA_REGISTRY_URL_NAME = "schema.registry.url";

    public static final String KAFKA_BOOTSTRAP_SERVERS = "kafka.bootstrap.servers";
    public static final String KAFKA_CLIENT_ID = "kafka.client.id";
    public static final String KAFKA_ACKS = "kafka.acks";
    public static final String KAFKA_RETRIES = "kafka.retries";
    public static final String KAFKA_REGISTRY_URL = "kafka.registryUrl";
    public static final String KAFKA_USE_AVRO = "kafka.useAvro";

    // DataX
    public static final String DATAX_TEMPLATE = "datax.template";
    public static final String DATAX_JOB_DIR = "datax.job.dir";
    public static final String DATAX_HOME_DIR = "datax.home.dir";
    public static final String DATAX_START_CMD = "datax.start.cmd";


    // constant
    public static final String CURRENT_TIME = "ctime";
    public static final String AGENT_IP = "agent";
    public static final String SUPPORT_TIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

}
