package com.example.demo.mapper;

import com.example.demo.model.ShoppingCart;
import com.example.demo.model.ShoppingCartExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShoppingCartMapper {
    int countByExample(ShoppingCartExample example);

    int deleteByExample(ShoppingCartExample example);

    int deleteByPrimaryKey(Integer shoppingCartId);

    int insert(ShoppingCart record);

    int insertSelective(ShoppingCart record);

    List<ShoppingCart> selectByExample(ShoppingCartExample example);

    ShoppingCart selectByPrimaryKey(Integer shoppingCartId);

    int updateByExampleSelective(@Param("record") ShoppingCart record, @Param("example") ShoppingCartExample example);

    int updateByExample(@Param("record") ShoppingCart record, @Param("example") ShoppingCartExample example);

    int updateByPrimaryKeySelective(ShoppingCart record);

    int updateByPrimaryKey(ShoppingCart record);
}