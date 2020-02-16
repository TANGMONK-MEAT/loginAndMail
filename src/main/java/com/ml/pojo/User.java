package com.ml.pojo;


/**
 * @author ZWL
 * @version 1.0
 * @date 2020/2/14 15:45
 */
public class User {
    /**
     * 用户编号
     */
    private Integer id;
    /**
     * 用户登录名
     */
    private String username;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户的电话
     */
    private String phone;

    public User(){}
    public User(int id,String username, String password, String phone, String email, String create_at,String last_login, String uname, String code) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.create_at = create_at;
        this.last_login = last_login;
        this.uname = uname;
        this.code = code;
    }
    public User(String username, String password, String phone, String email, String create_at,String last_login, String uname, String code) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.email = email;
        this.create_at = create_at;
        this.last_login = last_login;
        this.uname = uname;
        this.code = code;
    }

    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户信誉分
     */
    private String power;
    /**
     * 用户注册时间
     */
    private String create_at;
    /**
     * 最近一次登陆的时间
     */
    private String last_login;
    /**
     * 用户账号激活的状态
     */
    private byte status;
    /**
     * 用户的名字
     */
    private String uname;
    /**
     * 账户激活的激活码
     */
    private String code;
    /**
     * 验证码
     */
    private String checkCode;


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", power='" + power + '\'' +
                ", create_at='" + create_at + '\'' +
                ", last_login='" + last_login + '\'' +
                ", status=" + status +
                ", uname='" + uname + '\'' +
                ", code='" + code + '\'' +
                ", checkCode='" + checkCode + '\'' +
                '}';
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getCreate_at() {
        return create_at;
    }

    public void setCreate_at(String create_at) {
        this.create_at = create_at;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


}
