package com.blog.dao;

import com.blog.model.SecondCategory;
import com.blog.model.SecondCategoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SecondCategoryMapper {
    long countByExample(SecondCategoryExample example);

    int deleteByExample(SecondCategoryExample example);

    int deleteByPrimaryKey(Integer secCategoryId);

    int insert(SecondCategory record);

    int insertSelective(SecondCategory record);

    List<SecondCategory> selectByExample(SecondCategoryExample example);

    SecondCategory selectByPrimaryKey(Integer secCategoryId);

    int updateByExampleSelective(@Param("record") SecondCategory record, @Param("example") SecondCategoryExample example);

    int updateByExample(@Param("record") SecondCategory record, @Param("example") SecondCategoryExample example);

    int updateByPrimaryKeySelective(SecondCategory record);

    int updateByPrimaryKey(SecondCategory record);
}