package com.sczy.dao;

import com.sczy.entity.user;
import com.sczy.entity.role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface userdao {
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property ="username",column = "username"),
            @Result(property ="email",column = "email"),
            @Result(property ="password",column = "password"),
            @Result(property ="phoneNum",column = "phoneNum"),
            @Result(property ="statusStr",column = "statusStr"),
            @Result(property ="roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.sczy.dao.roleDao.findRoleByUserId"))
    })
    public user findByName(String username) throws  Exception;

    @Select("select * from users")
    List<user> findAll();
    @Insert("insert into users (email,username,password,phoneNum,status) values (#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(user user);

    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property ="username",column = "username"),
            @Result(property ="email",column = "email"),
            @Result(property ="password",column = "password"),
            @Result(property ="phoneNum",column = "phoneNum"),
            @Result(property ="status",column = "status"),
            @Result(property ="roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.sczy.dao.roleDao.findRoleByUserId"))
    })
    user findById(String id) throws Exception;

    @Select("select * from users where id in (select userid FROM Users_Role WHERE roleid = #{id})")
    List<user> findUserByRoleId(String id) throws  Exception;

    @Select("select * from role where id not in (select roleId from users_role where userId = #{userId})")
    List<role> findOtherRole(String userId);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{role})")
    void addRoleToUser(@Param("userId") String userId,@Param("role") String role);
    @Update("update users set password = #{password} where id = #{id}")
    void updatePwd(@Param("id") String id,@Param("password") String password);
}
