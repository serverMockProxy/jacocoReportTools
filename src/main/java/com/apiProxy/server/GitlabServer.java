package com.apiProxy.server;

import com.apiProxy.App;
import com.apiProxy.exception.ServerException;
import com.apiProxy.model.GitlabProject;
import com.apiProxy.model.vo.GitlabBranchesVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * @Author：hem
 * @Date：6/23/21 7:55 下午
 */
@Component
@Slf4j
public class GitlabServer {
    @Autowired
    private RestTemplate restTemplate;

    private static GitlabServer INSTANCE;

    //获取项目详情接口地址
    @Value("${gitHost}api/v4/projects/{projectId}")
    private String projectUrl;
    //获取commit号接口地址
    @Value("${gitHost}api/v4/projects/{projectId}/repository/commits?ref_name={branch}")
    private String commitsUrl;
    @Value("${gitHost}api/v4/projects/{projectId}/repository/branches")
    private String branchUrl;
    @Value("${gitToken}")
    private String gitToken;

    public static GitlabServer getInstance() {
        if (INSTANCE == null) {
            INSTANCE = App.getBean(GitlabServer.class);
        }
        return INSTANCE;
    }

    public GitlabProject getProjectById(Integer gitlabProjectId) {
        if(null == gitlabProjectId){
            throw new ServerException("gitLab Id未配置，需要在项目中配置gitlab Id");
        }
        GitlabProject gitlabProject = restTemplate.exchange(projectUrl,
                HttpMethod.GET,
                getEntity(),
                new ParameterizedTypeReference<GitlabProject>() {
                },
                gitlabProjectId).getBody();
        return gitlabProject;
    }

    public List<GitlabBranchesVo> getBranches(Integer gitlabProjectId){
        if(null == gitlabProjectId){
            throw new ServerException("gitLab Id未配置，需要在项目中配置gitlab Id");
        }
        List<GitlabBranchesVo> gitlabBranchesVos = restTemplate.exchange(branchUrl,
                HttpMethod.GET,
                getEntity(),
                new ParameterizedTypeReference<List<GitlabBranchesVo>>() {
                },
                gitlabProjectId).getBody();
        return gitlabBranchesVos;
    }

    public List<GitlabBranchesVo> getCommits(Integer gitlabProjectId,String branch){
        if(null == gitlabProjectId){
            throw new ServerException("gitLab Id未配置，需要在项目中配置gitlab Id");
        }
        List<GitlabBranchesVo> gitlabBranchesVos = restTemplate.exchange(commitsUrl,
                HttpMethod.GET,
                getEntity(),
                new ParameterizedTypeReference<List<GitlabBranchesVo>>() {
                },
                gitlabProjectId,branch).getBody();
        return gitlabBranchesVos;
    }

    private HttpEntity getEntity(){
        HttpHeaders headers = new HttpHeaders();
        headers.add("PRIVATE-TOKEN",gitToken);
        return new HttpEntity<>(null, headers);
    }
}
