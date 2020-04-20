package com.sczy.dao;

import com.sczy.entity.syslog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface sysdao {
    @Insert("insert into sysLog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(syslog sysLog) throws Exception;
    @Select("select * from sysLog")
    List<syslog> findAll();
}
