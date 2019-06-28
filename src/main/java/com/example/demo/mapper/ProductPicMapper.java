package com.example.demo.mapper;

import com.example.demo.model.ProductPic;
import com.example.demo.model.ProductPicExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductPicMapper {
    int countByExample(ProductPicExample example);

    int deleteByExample(ProductPicExample example);

    int deleteByPrimaryKey(Integer productPicId);

    int insert(ProductPic record);

    int insertSelective(ProductPic record);

    List<ProductPic> selectByExample(ProductPicExample example);

    ProductPic selectByPrimaryKey(Integer productPicId);

    int updateByExampleSelective(@Param("record") ProductPic record, @Param("example") ProductPicExample example);

    int updateByExample(@Param("record") ProductPic record, @Param("example") ProductPicExample example);

    int updateByPrimaryKeySelective(ProductPic record);

    int updateByPrimaryKey(ProductPic record);
}