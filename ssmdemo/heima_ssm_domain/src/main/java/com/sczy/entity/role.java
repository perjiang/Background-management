package com.sczy.entity;

import java.util.List;

public class role {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<permission> permissions;
    private List<user> users;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<permission> permissions) {
        this.permissions = permissions;
    }

    public List<user> getUsers() {
        return users;
    }

    public void setUsers(List<user> users) {
        this.users = users;
    }
}
