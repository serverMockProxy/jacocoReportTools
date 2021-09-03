package com.apiProxy.mbg.mapper;

import com.apiProxy.mbg.po.Jacoco;
import com.apiProxy.mbg.po.JacocoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JacocoMapper {
    long countByExample(JacocoExample example);

    int deleteByExample(JacocoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Jacoco record);

    int insertSelective(Jacoco record);

    List<Jacoco> selectByExample(JacocoExample example);

    Jacoco selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Jacoco record, @Param("example") JacocoExample example);

    int updateByExample(@Param("record") Jacoco record, @Param("example") JacocoExample example);

    int updateByPrimaryKeySelective(Jacoco record);

    int updateByPrimaryKey(Jacoco record);
}