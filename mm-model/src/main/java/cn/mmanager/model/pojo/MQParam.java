package cn.mmanager.model.pojo;

/**
 * 页面参数实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:25
 */
public class MQParam {
    /** 参数ID */
    private Long id;

    /** 调试消息 */
    private String message;

    /** 按钮消息 */
    private String button;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getButton() {
        return button;
    }

    public void setButton(String button) {
        this.button = button;
    }

    @Override
    public String toString() {
        return "MQParam{" +
                "id=" + id +
                ", message='" + message + '\'' +
                ", button='" + button + '\'' +
                '}';
    }
}
