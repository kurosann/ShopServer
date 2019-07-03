package com.example.demo.mapper;

import com.example.demo.model.FeedBack;
import com.example.demo.model.FeedbackExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FeedbackMapper {
    long countByExample(FeedbackExample example);

    int deleteByExample(FeedbackExample example);

    int deleteByPrimaryKey(Integer feedbackId);

    int insert(FeedBack record);

    int insertSelective(FeedBack record);

    List<FeedBack> selectByExample(FeedbackExample example);

    FeedBack selectByPrimaryKey(Integer feedbackId);

    List<FeedBack> selectLinkByFeedBackId(Integer UserId);

    int updateByExampleSelective(@Param("record") FeedBack record, @Param("example") FeedbackExample example);

    int updateByExample(@Param("record") FeedBack record, @Param("example") FeedbackExample example);

    int updateByPrimaryKeySelective(FeedBack record);

    int updateByPrimaryKey(FeedBack record);

}