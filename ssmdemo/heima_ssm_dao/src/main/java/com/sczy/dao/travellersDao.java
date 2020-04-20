package com.sczy.dao;

import com.sczy.entity.traveller;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface travellersDao {
    @Select("select * from  traveller where id in (select travellerId from order_traveller where orderId = #{ordersId}) ")
    public List<traveller> findByOrdersId(String ordersId) throws Exception;
}
