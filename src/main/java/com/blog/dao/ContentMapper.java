package com.blog.dao;

import com.blog.model.Content;
import com.blog.model.ContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ContentMapper {
    long countByExample(ContentExample example);

    int deleteByExample(ContentExample example);

    int deleteByPrimaryKey(Integer blogId);

    int insert(Content record);

    int insertSelective(Content record);

    List<Content> selectByExample(ContentExample example);

    Content selectByPrimaryKey(Integer blogId);

    int updateByExampleSelective(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByExample(@Param("record") Content record, @Param("example") ContentExample example);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKey(Content record);
}