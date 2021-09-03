package com.apiProxy.mbg.mapper;

import com.apiProxy.mbg.po.ProxyDetails;
import com.apiProxy.mbg.po.ProxyDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProxyDetailsMapper {
    long countByExample(ProxyDetailsExample example);

    int deleteByExample(ProxyDetailsExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProxyDetails record);

    int insertSelective(ProxyDetails record);

    List<ProxyDetails> selectByExample(ProxyDetailsExample example);

    ProxyDetails selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProxyDetails record, @Param("example") ProxyDetailsExample example);

    int updateByExample(@Param("record") ProxyDetails record, @Param("example") ProxyDetailsExample example);

    int updateByPrimaryKeySelective(ProxyDetails record);

    int updateByPrimaryKey(ProxyDetails record);
}