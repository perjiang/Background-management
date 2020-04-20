package com.sczy.dao;

import com.sczy.entity.product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface productDao {

    @Select("select * from product where id = #{id}")
    public product findById(String id);
    @Select("SELECT * FROM product")
    public List<product> findALl() throws  Exception;
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    public void save(product product) throws Exception;
}
