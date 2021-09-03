package com.apiProxy.mbg.mapper;

import com.apiProxy.mbg.po.UserProject;
import com.apiProxy.mbg.po.UserProjectExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserProjectMapper {
    long countByExample(UserProjectExample example);

    int deleteByExample(UserProjectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserProject record);

    int insertSelective(UserProject record);

    List<UserProject> selectByExample(UserProjectExample example);

    UserProject selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") UserProject record, @Param("example") UserProjectExample example);

    int updateByExample(@Param("record") UserProject record, @Param("example") UserProjectExample example);

    int updateByPrimaryKeySelective(UserProject record);

    int updateByPrimaryKey(UserProject record);
}