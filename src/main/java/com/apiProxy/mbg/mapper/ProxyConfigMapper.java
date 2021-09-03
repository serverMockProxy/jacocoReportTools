package com.apiProxy.mbg.mapper;

import com.apiProxy.mbg.po.ProxyConfig;
import com.apiProxy.mbg.po.ProxyConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProxyConfigMapper {
    long countByExample(ProxyConfigExample example);

    int deleteByExample(ProxyConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProxyConfig record);

    int insertSelective(ProxyConfig record);

    List<ProxyConfig> selectByExample(ProxyConfigExample example);

    ProxyConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProxyConfig record, @Param("example") ProxyConfigExample example);

    int updateByExample(@Param("record") ProxyConfig record, @Param("example") ProxyConfigExample example);

    int updateByPrimaryKeySelective(ProxyConfig record);

    int updateByPrimaryKey(ProxyConfig record);
}