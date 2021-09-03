package com.apiProxy.service;

import com.apiProxy.exception.ServerException;
import com.apiProxy.mbg.mapper.ProjectMapper;
import com.apiProxy.mbg.po.Project;
import com.apiProxy.mbg.po.ProjectExample;
import com.apiProxy.mbg.po.User;
import com.apiProxy.model.PageRequest;
import com.apiProxy.model.PagedData;
import com.apiProxy.model.vo.ProjectVo;
import com.apiProxy.security.SecurityUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@Service
public class ProjectService {

    @Autowired
    private ProjectMapper projectMapper;
    @Autowired
    private UserService userService;

    public void add(Project project) {
        project.setCreateTime(new Date());
        project.setCreatorUid(SecurityUtil.getCurrentUserId());

        try {
            int insertCount = projectMapper.insertSelective(project);
            if (insertCount != 1) {
                throw new ServerException("添加失败，请稍后重试");
            }
        } catch (DuplicateKeyException e) {
            throw new ServerException(project.getName() + "已存在");
        }
    }

    public void delete(Integer projectId) {
        if (projectId == null) {
            throw new ServerException("projectId不能为空");
        }

        int deleteCount = projectMapper.deleteByPrimaryKey(projectId);
        if (deleteCount != 1) {
            throw new ServerException("删除失败，请稍后重试");
        }
    }

    public void update(Project project) {
        try {
            int updateCount = projectMapper.updateByPrimaryKeySelective(project);
            if (updateCount != 1) {
                throw new ServerException("更新失败，请稍后重试");
            }
        } catch (DuplicateKeyException e) {
            throw new ServerException(project.getName() + "已存在");
        }
    }

    public PagedData<ProjectVo> list(Project query, String orderBy, PageRequest pageRequest) {
        Page page = PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());

        if (StringUtils.isEmpty(orderBy)) {
            orderBy = "create_time desc";
        }

        List<ProjectVo> projectVos = getProjectVos(query, orderBy);
        return new PagedData<>(projectVos, page.getTotal());
    }

    private List<ProjectVo> convertProjectsToProjectVos(List<Project> projects) {
        if (CollectionUtils.isEmpty(projects)) {
            return new ArrayList<>();
        }

        List<Integer> creatorUids = projects.stream()
                .map(Project::getCreatorUid)
                .filter(Objects::nonNull)
                .distinct()
                .collect(Collectors.toList());
        Map<Integer, User> userMap = userService.getUserMapByIds(creatorUids);

        List<ProjectVo> projectVos = projects.stream().map(project -> {
            ProjectVo projectVo = new ProjectVo();
            BeanUtils.copyProperties(project, projectVo);

            if (project.getCreatorUid() != null) {
                User user = userMap.get(project.getCreatorUid());
                if (user != null) {
                    projectVo.setCreatorNickName(user.getNickName());
                }
            }

            return projectVo;
        }).collect(Collectors.toList());

        return projectVos;
    }

    public List<ProjectVo> getProjectVos(Project query, String orderBy) {
        List<Project> projects = getProjects(query, orderBy);
        return convertProjectsToProjectVos(projects);
    }

    public List<Project> getProjects(Project query, String orderBy) {
        ProjectExample example = new ProjectExample();
        ProjectExample.Criteria criteria = example.createCriteria();

        if (query != null) {
            if (query.getId() != null) {
                criteria.andIdEqualTo(query.getId());
            }
            if (!StringUtils.isEmpty(query.getName())) {
                criteria.andNameEqualTo(query.getName());
            }
        }

        if (!StringUtils.isEmpty(orderBy)) {
            example.setOrderByClause(orderBy);
        }

        return projectMapper.selectByExample(example);
    }
    public List<Project> getAll() {
        return projectMapper.selectByExample(null);
    }

    public Project getProjetctById(Integer projectId){
        return projectMapper.selectByPrimaryKey(projectId);
    }
}
