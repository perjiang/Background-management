package com.sczy.dao;

import com.sczy.entity.member;
import com.sczy.entity.orders;
import com.sczy.entity.product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface orderDao {
    @Select("select * from orders")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = product.class,one = @One(select = "com.sczy.dao.productDao.findById")),
    })
    public List<orders> findAll() throws Exception;
    @Select("select * from orders where id = #{ordersId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "orderNum",column = "orderNum"),
            @Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property = "product",column = "productId",javaType = product.class,one = @One(select = "com.sczy.dao.productDao.findById")),
            @Result(property = "member",column = "memberId",javaType = member.class,one = @One(select = "com.sczy.dao.memberDao.findById")),
            @Result(property = "travellers",column = "id",javaType = java.util.List.class,many = @Many(select = "com.sczy.dao.travellersDao.findByOrdersId"))
    })
    public orders findById(String ordersId) throws  Exception;
}
