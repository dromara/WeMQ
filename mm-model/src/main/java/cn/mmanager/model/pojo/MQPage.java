package cn.mmanager.model.pojo;

import java.util.List;

/**
 * 页面实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:20
 */
public class MQPage {
    /** 页面ID */
    private Long id;

    /** 页面名称 */
    private String pageName;

    /** 页面URL */
    private String pageUrl;

    /** Nmqs Token ID */
    private String nmqsTokenID;

    /** 页面状态 */
    private int status;

    /** 页面参数 */
    List<MQParam> mqParams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
    }

    public String getNmqsTokenID() {
        return nmqsTokenID;
    }

    public void setNmqsTokenID(String nmqsTokenID) {
        this.nmqsTokenID = nmqsTokenID;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<MQParam> getMqParams() {
        return mqParams;
    }

    public void setMqParams(List<MQParam> mqParams) {
        this.mqParams = mqParams;
    }

    @Override
    public String toString() {
        return "MQPage{" +
                "id=" + id +
                ", pageName='" + pageName + '\'' +
                ", pageUrl='" + pageUrl + '\'' +
                ", nmqsTokenID='" + nmqsTokenID + '\'' +
                ", status=" + status +
                ", mqParams=" + mqParams +
                '}';
    }
}
