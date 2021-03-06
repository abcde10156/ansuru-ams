package com.ansuru.ams.svr.user.entity;

import java.util.Date;

public class UserAdmin {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_admin.id
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_admin.username
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    private String username;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_admin.password
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    private String password;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_admin.login_time
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    private Date loginTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_admin.logout_time
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    private Date logoutTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_admin.realname
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    private String realname;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_admin.id
     *
     * @return the value of user_admin.id
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_admin.id
     *
     * @param id the value for user_admin.id
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_admin.username
     *
     * @return the value of user_admin.username
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_admin.username
     *
     * @param username the value for user_admin.username
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_admin.password
     *
     * @return the value of user_admin.password
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_admin.password
     *
     * @param password the value for user_admin.password
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_admin.login_time
     *
     * @return the value of user_admin.login_time
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    public Date getLoginTime() {
        return loginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_admin.login_time
     *
     * @param loginTime the value for user_admin.login_time
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_admin.logout_time
     *
     * @return the value of user_admin.logout_time
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    public Date getLogoutTime() {
        return logoutTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_admin.logout_time
     *
     * @param logoutTime the value for user_admin.logout_time
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    public void setLogoutTime(Date logoutTime) {
        this.logoutTime = logoutTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_admin.realname
     *
     * @return the value of user_admin.realname
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_admin.realname
     *
     * @param realname the value for user_admin.realname
     *
     * @mbggenerated Fri Sep 13 16:14:47 CST 2019
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }
}