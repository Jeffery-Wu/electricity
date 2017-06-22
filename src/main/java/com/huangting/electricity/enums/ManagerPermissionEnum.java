package com.huangting.electricity.enums;

/**
 * Created by huangting on 2017/6/20.
 */
public enum ManagerPermissionEnum {

    SUPER_MANAGER(0,"拥有系统的最高权限","超级管理员"),

    NORMAL_MANAGER(1,"具备系统的一般权限","普通管理员");

    /**
     * 管理员权限的标识ID
     */
    private Integer permissionId;

    /**
     * 管理员名字
     */
    private String name;

    /**
     * 管理员权限描述
     */
    private String description;

    ManagerPermissionEnum(Integer permissionId, String description, String name) {
        this.permissionId = permissionId;
        this.description = description;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
