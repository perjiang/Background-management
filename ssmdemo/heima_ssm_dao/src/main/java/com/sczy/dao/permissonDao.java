package com.sczy.dao;

import com.sczy.entity.permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface permissonDao {

    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    public List<permission> findPermissonById(String id);

    @Select("select * from permission")
    public List<permission> findAll() throws Exception;
    @Insert("insert into permission (permissionName,url) values (#{permissionName},#{url})")
    void save(permission permission);

    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
    public List<permission> findPermissionByRoleId(String id) throws Exception;
}
