package com.example.demo.mapper;

import com.example.demo.model.FeedBackImage;
import com.example.demo.model.FeedbackImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeedbackImageMapper {
    long countByExample(FeedbackImageExample example);

    int deleteByExample(FeedbackImageExample example);

    int deleteByPrimaryKey(Integer feedbackImageId);

    int insert(FeedBackImage record);

    int insertSelective(FeedBackImage record);

    List<FeedBackImage> selectByExample(FeedbackImageExample example);

    FeedBackImage selectByPrimaryKey(Integer feedbackImageId);

    int updateByExampleSelective(@Param("record") FeedBackImage record, @Param("example") FeedbackImageExample example);

    int updateByExample(@Param("record") FeedBackImage record, @Param("example") FeedbackImageExample example);

    int updateByPrimaryKeySelective(FeedBackImage record);

    int updateByPrimaryKey(FeedBackImage record);
}