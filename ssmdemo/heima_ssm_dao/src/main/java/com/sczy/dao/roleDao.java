package com.sczy.dao;

import com.sczy.entity.permission;
import com.sczy.entity.role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface roleDao {
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.sczy.dao.permissonDao.findPermissonById"))
    })
    List<role> findRoleByUserId(String id);


    @Select("select * from role")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.sczy.dao.permissonDao.findPermissonById")),
            @Result(property = "users",column = "id",javaType = java.util.List.class,many = @Many(select = "com.sczy.dao.userdao.findUserByRoleId"))
    })
    List<role> findAll() throws Exception;

    @Insert("insert into role (rolename,roledesc) values (#{roleName},#{roleDesc})")
    void save(role role);

    @Select("select * from role where id=#{roleId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.sczy.dao.permissonDao.findPermissionByRoleId"))
    })
    role findById(String roleId);

    @Select("SELECT * FROM permission WHERE ID NOT IN(SELECT permissionid FROM role_permission WHERE roleid = #{roleId}) ")
    List<permission> findOtherPermission(String roleId);

    @Insert("insert into Role_Permission (permissionid,roleid) values(#{perId},#{roleId})")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("perId") String perId);
}
