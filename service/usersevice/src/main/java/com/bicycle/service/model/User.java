package com.bicycle.service.model;

/**
 * @author miujoke
 * @date 2025/3/17 0:10
 */
import java.time.LocalDateTime;


public class User {


    private Long id;  // 主键

    private String account; // 账号

    private String password; // 密码（建议加密存储）

    private String nickname; // 昵称

    private String avatar; // 头像 URL

    private String email; // 邮箱

    private LocalDateTime createTime; // 创建时间

    private LocalDateTime updateTime; // 更新时间

    // 在插入数据时自动填充时间
    protected void onCreate() {
        this.createTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
    }

    // 在更新数据时自动更新 `updateTime`
    protected void onUpdate() {
        this.updateTime = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}

