package cn.mmanager.model.pojo;

/**
 * 管理员实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:16
 */
public class Admin {
    /** 管理员ID */
    private Long id;

    /** 管理员用户名 */
    private String username;

    /** 管理员昵称 */
    private String nickname;

    /** 管理员密码 */
    private String password;

    /** 管理员状态 */
    private int status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                '}';
    }
}
