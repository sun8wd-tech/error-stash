package com.celloud.errorstash.model;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.Map;

/**
 * 异常在mongo中的实体类
 *
 * @author <a href="mailto:sunwendong@celloud.cn">sunwd</a>
 * @create 2017/12/19 上午11:02
 */
public class Error {
    /**
     * 主键
     */
    @Id
    private String id;
    /**
     * 发生异常的模块：oms、jss、crm等
     */
    private String module;
    /**
     * 发生异常的用户id
     */
    private Integer userId;
    /**
     * 发生异常的用户名
     */
    private String username;
    /**
     * 异常地址的访问方法
     */
    private String httpMethod;
    /**
     * 发生异常的访问地址
     */
    private String url;
    /**
     * 发生异常的参数
     */
    private Map<String, Object> params;
    /**
     * 发生异常时，用户使用的浏览器
     */
    private String os;
    /**
     * 发生异常时，用户的ip地址
     */
    private String ip;
    /**
     * 发生异常时，用户的地址(根据ip地址解析)
     */
    private String address;
    /**
     * 发生异常时，用户使用的浏览器
     */
    private String browser;
    /**
     * 发生异常时，用户的userAgent信息
     */
    private String userAgent;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 异常的描述信息
     */
    private String message;
    /**
     * 异常的栈信息
     */
    private String stackTrace;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Map<String, Object> getParams() {
        return params;
    }

    public void setParams(Map<String, Object> params) {
        this.params = params;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStackTrace() {
        return stackTrace;
    }

    public void setStackTrace(String stackTrace) {
        this.stackTrace = stackTrace;
    }
}
