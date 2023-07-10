package cn.mmanager.model.pojo;

/**
 * NmqsToken实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:29
 */
public class NmqsToken {
    /** TokenID */
    private Long id;

    /** Token名称 */
    private String name;

    /** Token */
    private String token;

    /** 协议 **/
    private int protocol;

    /** 服务器地址 */
    private String mqttServer;

    /** 服务器端口 */
    private int mqttPort;

    /** 服务器用户名 */
    private String mqttUsername;

    /** 服务器密码 */
    private String mqttPassword;

    /** 发布订阅 */
    private String mqttSendTopic;

    /** 接收订阅 */
    private String mqttReceiveTopic;

    /** Qos */
    private int mqttQos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMqttServer() {
        return mqttServer;
    }

    public void setMqttServer(String mqttServer) {
        this.mqttServer = mqttServer;
    }

    public int getMqttPort() {
        return mqttPort;
    }

    public void setMqttPort(int mqttPort) {
        this.mqttPort = mqttPort;
    }

    public String getMqttUsername() {
        return mqttUsername;
    }

    public void setMqttUsername(String mqttUsername) {
        this.mqttUsername = mqttUsername;
    }

    public String getMqttPassword() {
        return mqttPassword;
    }

    public void setMqttPassword(String mqttPassword) {
        this.mqttPassword = mqttPassword;
    }

    public String getMqttSendTopic() {
        return mqttSendTopic;
    }

    public void setMqttSendTopic(String mqttSendTopic) {
        this.mqttSendTopic = mqttSendTopic;
    }

    public String getMqttReceiveTopic() {
        return mqttReceiveTopic;
    }

    public void setMqttReceiveTopic(String mqttReceiveTopic) {
        this.mqttReceiveTopic = mqttReceiveTopic;
    }

    public int getMqttQos() {
        return mqttQos;
    }

    public void setMqttQos(int mqttQos) {
        this.mqttQos = mqttQos;
    }

    public int getProtocol() {
        return protocol;
    }

    public void setProtocol(int protocol) {
        this.protocol = protocol;
    }

    @Override
    public String toString() {
        return "NmqsToken{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", token='" + token + '\'' +
                ", protocol='" + protocol + '\'' +
                ", mqttServer='" + mqttServer + '\'' +
                ", mqttPort=" + mqttPort +
                ", mqttUsername='" + mqttUsername + '\'' +
                ", mqttPassword='" + mqttPassword + '\'' +
                ", mqttSendTopic='" + mqttSendTopic + '\'' +
                ", mqttReceiveTopic='" + mqttReceiveTopic + '\'' +
                ", mqttQos=" + mqttQos +
                '}';
    }
}
