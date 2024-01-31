package com.flipkart.bean;

public class Role {
    private int userId;

    /**
     * Get the user ID.
     *
     * @return The user ID.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set the user ID.
     *
     * @param userId The user ID to set.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Get the role.
     *
     * @return The role.
     */
    public String getRole() {
        return role;
    }

    /**
     * Set the role.
     *
     * @param role The role to set.
     */
    public void setRole(String role) {
        this.role = role;
    }

    private String role;
}
