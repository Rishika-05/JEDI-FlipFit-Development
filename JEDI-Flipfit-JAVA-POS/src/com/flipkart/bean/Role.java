package com.flipkart.bean;

import com.flipkart.constant.RoleType;

public class Role {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public RoleType getRole() {
        return role;
    }

    public void setRole(RoleType role) {
        this.role = role;
    }

    private RoleType role;
}
