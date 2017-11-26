package com.xiang.mail;

import java.util.Properties;

public class Mail {

    private String mailServerHost;// 发送邮件的服务器的IP
    private String mailServerPort;// 发送邮件的服务器的端口
    private String fromAddress;// 邮件发送者的地址
    private String[] toAddress; // 发送邮件接收者的地址 数组，
    private String[] ccAddress; // 抄送邮件接收者的地址 数组，
    private String[] bccAddress; // 秘密抄送邮件接收者的地址 数组，
    private String userName;// 登陆邮件发送服务器的用户名
    private String password;// 登陆邮件发送服务器的密码
    private boolean validate = true;// 是否需要身份验证
    private String subject;// 邮件主题
    private String content;// 邮件的文本内容
    private String[] attachFileNames;// 邮件附件的文件名
    private boolean debug = false;
    private Properties p;

    /**
     * 获得邮件会话属性
     */
    public Properties getProperties() {
        if (p == null) {
            p = new Properties();
            p.put("mail.smtp.host", this.mailServerHost);
            p.put("mail.smtp.port", this.mailServerPort);
            p.put("mail.smtp.**ssl.enable", "true");
            p.put("mail.smtp.**ssl.required", "true");
            p.put("mail.smtp.auth", validate ? "true" : "false");
            p.put("mail.smtp.starttls.enable", "true");// qq 需要，如果不加，会出现认证失败，163 不需要
            p.put("mail.debug", debug ? "true" : "false");
        }
        return p;
    }

    /**
     * 设置属性
     *
     * @param p
     */
    public void setProperties(Properties p) {
        this.p = p;

    }

    /**
     * 设置调试开关
     *
     * @param debug
     */
    public void setDebug(boolean debug) {
        this.debug = debug;
    }

    public String getMailServerHost() {
        return mailServerHost;
    }

    /**
     * 设置邮箱服务器地址
     *
     * @param mailServerHost
     */
    public void setMailServerHost(String mailServerHost) {
        this.mailServerHost = mailServerHost;
    }

    public String getMailServerPort() {
        return mailServerPort;
    }

    /**
     * 设置邮箱服务器端口 一般都是25
     *
     * @param mailServerPort
     */
    public void setMailServerPort(String mailServerPort) {
        this.mailServerPort = mailServerPort;
    }

    public boolean isValidate() {
        return validate;
    }

    public void setValidate(boolean validate) {
        this.validate = validate;
    }

    public String[] getAttachFileNames() {
        return attachFileNames;
    }

    public void setAttachFileNames(String[] fileNames) {
        this.attachFileNames = fileNames;
    }

    public String getFromAddress() {
        return fromAddress;
    }

    public void setFromAddress(String fromAddress) {
        this.fromAddress = fromAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getToAddress() {
        return toAddress;
    }

    public void setToAddress(String[] toAddress) {
        this.toAddress = toAddress;
    }

    public String[] getCcAddress() {
        return ccAddress;
    }

    public void setCcAddress(String[] ccAddress) {
        this.ccAddress = ccAddress;
    }

    public String[] getBccAddress() {
        return bccAddress;
    }

    public void setBccAddress(String[] bccAddress) {
        this.bccAddress = bccAddress;
    }

    public String getUserName() {
        return userName;
    }

    /**
     * 设置 用户名 QQ邮箱 一定要用@qq.com 前面的字符串，比如QQ号
     * 163 全邮箱或者用户名
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String textContent) {
        this.content = textContent;
    }
}
