package com.apiProxy.dao;

import com.apiProxy.mbg.po.UserProject;
import com.apiProxy.model.dto.UserProjectDto;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
public interface UserProjectDao {
    int insertBatch(@Param("userProjects") List<UserProject> userProjects);

    List<UserProjectDto> selectUserProjectDtosByUserIds(@Param("userIds") List<Integer> userIds);
}
