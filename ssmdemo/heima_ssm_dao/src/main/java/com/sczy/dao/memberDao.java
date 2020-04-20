package com.sczy.dao;

import com.sczy.entity.member;
import org.apache.ibatis.annotations.Select;

public interface memberDao {
    @Select("select * from member where id = #{id}")
    public member findById(String id) throws Exception;
}
