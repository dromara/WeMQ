package cn.mmanager.model.dto;

import cn.mmanager.model.pojo.Customer;
import cn.mmanager.model.pojo.MQParam;
import cn.mmanager.model.pojo.NmqsToken;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * 页面实体类
 * @author NicholasLD
 * @createTime 2023/4/8 13:20
 */
//@JsonIgnoreProperties(value = {"handler"})
public class MqPageDto implements Serializable {
    private static final long serialVersionUID = 1L;
    /** 页面ID */
    private Long id;

    /** 页面名称 */
    private String pageName;

    /** 页面URL */
    private String pageUrl;

    /** 页面文件名 */
    private String pageFileName;

    /** Nmqs Token ID */
    private Long nmqsTokenID;

    /** 服务器设置 */
    private NmqsToken settings;

    /** 客户 */
    private Customer customer;

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

    public Long getNmqsTokenID() {
        return nmqsTokenID;
    }

    public void setNmqsTokenID(Long nmqsTokenID) {
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

    public NmqsToken getSettings() {
        return settings;
    }

    public void setSettings(NmqsToken settings) {
        this.settings = settings;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getPageFileName() {
        return pageFileName;
    }

    public void setPageFileName(String pageFileName) {
        this.pageFileName = pageFileName;
    }

    @Override
    public String toString() {
        return "MqPageDto{" +
                "id=" + id +
                ", pageName='" + pageName + '\'' +
                ", pageUrl='" + pageUrl + '\'' +
                ", pageFileName='" + pageFileName + '\'' +
                ", nmqsTokenID=" + nmqsTokenID +
                ", settings=" + settings +
                ", customer=" + customer +
                ", status=" + status +
                ", mqParams=" + mqParams +
                '}';
    }
}
