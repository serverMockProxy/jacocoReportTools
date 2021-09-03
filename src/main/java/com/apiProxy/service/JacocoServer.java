package com.apiProxy.service;

import com.apiProxy.exception.ServerException;
import com.apiProxy.mbg.mapper.JacocoMapper;
import com.apiProxy.mbg.po.Jacoco;
import com.apiProxy.mbg.po.JacocoConfig;
import com.apiProxy.mbg.po.JacocoExample;
import com.apiProxy.mbg.po.Project;
import com.apiProxy.model.GitlabProject;
import com.apiProxy.model.PageRequest;
import com.apiProxy.model.PagedData;
import com.apiProxy.model.vo.GitlabBranchesVo;
import com.apiProxy.server.GitlabServer;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @Author：hem
 * @Date：6/24/21 6:29 下午
 */
@Service
@Slf4j
public class JacocoServer {

    @Autowired
    private GitlabServer gitlabServer;

    @Autowired
    private ProjectService projectService;

    @Autowired
    private JacocoMapper jacocoMapper;

    @Value("${static-location}/upload/exec")
    private String exexPath;
    @Value("${static-location}/frontend/jacoco")
    private String reportPath;


    public List<GitlabBranchesVo> getBranches(Integer gitId){
//        Project project = projectService.getProjetctById(projectId);
        return gitlabServer.getBranches(gitId);
    }

    public List<GitlabBranchesVo> getCommits(Integer gitId,String branch){
//        Project project = projectService.getProjetctById(projectId);
        return gitlabServer.getCommits(gitId,branch);
    }

    public void creatReport(Jacoco jacoco){
        setGitValue(jacoco);
        if (!CollectionUtils.isEmpty(jacoco.getChildrens())){
            jacoco.getChildrens().stream().forEach(jacoco1 -> {
                setGitValue(jacoco1);
            });
        }
        try {
            int insertCount = jacocoMapper.insert(jacoco);
            if (insertCount != 1) {
                throw new ServerException("提交任务失败，请稍后重试");
            }
        } catch (DuplicateKeyException e) {
            throw new ServerException(jacoco.getId() + "已存在");
        }
    }

    private void setGitValue(Jacoco jacoco){
        GitlabProject gitlabProject = gitlabServer.getProjectById(jacoco.getGitlabId());
        jacoco.setTaskStatus(0);
        jacoco.setGitclonePath(gitlabProject.getPath_with_namespace() + ".git");
        jacoco.setJacocoProjectName(gitlabProject.getPath());
    }

    public List<Jacoco> getJacoco(Jacoco query ,String orderBy){
        JacocoExample example = new JacocoExample();
        JacocoExample.Criteria criteria = example.createCriteria();

        if (query != null) {
            if (query.getId() != null) {
                criteria.andIdEqualTo(query.getId());
            }
            if (query.getTaskStatus() != null){
                criteria.andTaskStatusEqualTo(query.getTaskStatus());
            }
            if (query.getProjectId() != null){
                criteria.andProjectIdEqualTo(query.getProjectId());
            }
        }
        if (!StringUtils.isEmpty(orderBy)) {
            example.setOrderByClause(orderBy);
        }
        return jacocoMapper.selectByExample(example);
    }

    public void update(Jacoco jacoco){
        try {
            int updateCount = jacocoMapper.updateByPrimaryKeySelective(jacoco);
            if (updateCount != 1) {
                throw new ServerException("更新失败，请稍后重试");
            }
        } catch (DuplicateKeyException e) {
            throw new ServerException(jacoco.getId() + "已存在");
        }
    }

    public PagedData<Jacoco> list(Jacoco query, String orderBy, PageRequest pageRequest) {
        Page page = PageHelper.startPage(pageRequest.getPageNum(), pageRequest.getPageSize());

        if (StringUtils.isEmpty(orderBy)) {
            orderBy = "id desc";
        }

        List<Jacoco> jacocos = getJacoco(query, orderBy);
        return new PagedData<>(jacocos, page.getTotal());
    }

    public List<Jacoco> getUnFinishedTasks() {
        Jacoco query = new Jacoco();
        query.setTaskStatus(0);
        return getJacoco(query,null);
    }

    public void delete(List<Integer> ids){
        if (CollectionUtils.isEmpty(ids)) {
            throw new ServerException("Id不能为空");
        }
        JacocoExample example = new JacocoExample();
        JacocoExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(ids);
        int deleteCount = jacocoMapper.deleteByExample(example);
        if (deleteCount < 1) {
            throw new ServerException("删除失败，请稍后重试");
        }
    }
}
