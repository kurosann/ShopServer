package com.example.demo.mapper;

import com.example.demo.model.CollectionSQL;
import com.example.demo.model.CollectionSQLExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CollectionSQLMapper {
    int countByExample(CollectionSQLExample example);

    int deleteByExample(CollectionSQLExample example);

    int deleteByPrimaryKey(Integer collectionId);

    int insert(CollectionSQL record);

    int insertSelective(CollectionSQL record);

    List<CollectionSQL> selectByExample(CollectionSQLExample example);

    CollectionSQL selectByPrimaryKey(Integer collectionId);

    int updateByExampleSelective(@Param("record") CollectionSQL record, @Param("example") CollectionSQLExample example);

    int updateByExample(@Param("record") CollectionSQL record, @Param("example") CollectionSQLExample example);

    int updateByPrimaryKeySelective(CollectionSQL record);

    int updateByPrimaryKey(CollectionSQL record);
}