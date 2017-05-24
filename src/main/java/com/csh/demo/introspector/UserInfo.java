package com.csh.demo.introspector;

/**
 * JavaBean demo
 * @author chenshenghong
 * @version 1.0
 * @created 2017/5/24
 * @time 下午11:40
 */
public class UserInfo {
    private Long userId;
    private String userName;
    private Integer age;
    private String emailAddress;

    public UserInfo() {
    }

    public UserInfo(Long userId, String userName, Integer age, String emailAddress) {
        this.userId = userId;
        this.userName = userName;
        this.age = age;
        this.emailAddress = emailAddress;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }
}
