package com.apiProxy.mbg.mapper;

import com.apiProxy.mbg.po.JacocoConfig;
import com.apiProxy.mbg.po.JacocoConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface JacocoConfigMapper {
    long countByExample(JacocoConfigExample example);

    int deleteByExample(JacocoConfigExample example);

    int insert(JacocoConfig record);

    int insertSelective(JacocoConfig record);

    List<JacocoConfig> selectByExample(JacocoConfigExample example);

    JacocoConfig selectByPrimaryKey(Integer projectId);

    int updateByExampleSelective(@Param("record") JacocoConfig record, @Param("example") JacocoConfigExample example);

    int updateByExample(@Param("record") JacocoConfig record, @Param("example") JacocoConfigExample example);

    int updateByPrimaryKey(JacocoConfig record);
}