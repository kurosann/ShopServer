package com.example.demo.mapper;

import com.example.demo.model.FeedbackImage;
import com.example.demo.model.FeedbackImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeedbackImageMapper {
    long countByExample(FeedbackImageExample example);

    int deleteByExample(FeedbackImageExample example);

    int deleteByPrimaryKey(Integer feedbackImageId);

    int insert(FeedbackImage record);

    int insertSelective(FeedbackImage record);

    List<FeedbackImage> selectByExample(FeedbackImageExample example);

    FeedbackImage selectByPrimaryKey(Integer feedbackImageId);

    int updateByExampleSelective(@Param("record") FeedbackImage record, @Param("example") FeedbackImageExample example);

    int updateByExample(@Param("record") FeedbackImage record, @Param("example") FeedbackImageExample example);

    int updateByPrimaryKeySelective(FeedbackImage record);

    int updateByPrimaryKey(FeedbackImage record);
}