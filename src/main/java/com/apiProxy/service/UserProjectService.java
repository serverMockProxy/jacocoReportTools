package com.apiProxy.service;

import com.apiProxy.dao.UserProjectDao;
import com.apiProxy.exception.ServerException;
import com.apiProxy.mbg.mapper.UserProjectMapper;
import com.apiProxy.mbg.po.Project;
import com.apiProxy.mbg.po.UserProject;
import com.apiProxy.mbg.po.UserProjectExample;
import com.apiProxy.model.dto.UserProjectDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@Service
public class UserProjectService {

    @Autowired
    private UserProjectMapper userProjectMapper;
    @Autowired
    private UserProjectDao userProjectDao;

    public void addBatch(List<UserProject> userProjects) {
        if (CollectionUtils.isEmpty(userProjects)) {
            return;
        }

        int insertCount = userProjectDao.insertBatch(userProjects);
        if (insertCount != userProjects.size()) {
            throw new ServerException("添加失败");
        }
    }

    public void addBatch(Integer userId, List<Project> projects) {
        if (CollectionUtils.isEmpty(projects)){
            return;
        }
        List<UserProject> userProjects = projects.stream().map(project -> {
            UserProject userProject = new UserProject();
            userProject.setUserId(userId);
            userProject.setProjectId(project.getId());
            return userProject;
        }).collect(Collectors.toList());

        addBatch(userProjects);
    }

    public int deleteByUserId(Integer userId) {
        UserProjectExample example = new UserProjectExample();
        UserProjectExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId);

        return userProjectMapper.deleteByExample(example);
    }

    public List<UserProjectDto> getUserProjectDtosByUserIds(List<Integer> userIds) {
        if (CollectionUtils.isEmpty(userIds)) {
            return new ArrayList<>();
        }

        return userProjectDao.selectUserProjectDtosByUserIds(userIds);
    }
}
