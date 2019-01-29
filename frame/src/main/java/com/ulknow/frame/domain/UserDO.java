package com.ulknow.frame.domain;

import javax.persistence.*;

@Table(name = "users")
public class UserDO {
    /**
     * 递增id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 密码加盐
     */
    @Column(name = "password_salt")
    private String passwordSalt;

    /**
     * 获取递增id
     *
     * @return id - 递增id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置递增id
     *
     * @param id 递增id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户名
     *
     * @return username - 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户名
     *
     * @param username 用户名
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取密码加盐
     *
     * @return password_salt - 密码加盐
     */
    public String getPasswordSalt() {
        return passwordSalt;
    }

    /**
     * 设置密码加盐
     *
     * @param passwordSalt 密码加盐
     */
    public void setPasswordSalt(String passwordSalt) {
        this.passwordSalt = passwordSalt == null ? null : passwordSalt.trim();
    }
}