package com.apiProxy.controller;

import com.apiProxy.mbg.po.Jacoco;
import com.apiProxy.model.PageRequest;
import com.apiProxy.model.PagedData;
import com.apiProxy.model.Response;
import com.apiProxy.model.vo.GitlabBranchesVo;
import com.apiProxy.service.JacocoServer;
import com.apiProxy.utils.HttpServletUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author：hem
 * @Date：6/24/21 4:28 下午
 */
@RestController
@RequestMapping("/jacoco")
public class JacocoController {
    public static String url;
    @Autowired
    private JacocoServer jacocoServer;

    @PostMapping("/creatReport")
    public Response creatReport(@Valid @RequestBody Jacoco jacoco) {
        url = HttpServletUtil.getStaticResourceBaseUrl().toString();
        jacocoServer.creatReport(jacoco);
        return Response.success("任务提交成功");
    }

    @GetMapping("/getBranches/{gitId}")
    public Response getBranches(@PathVariable Integer gitId) {
        List<GitlabBranchesVo> gitlabBranchesVos = jacocoServer.getBranches(gitId);
        return Response.success(gitlabBranchesVos);
    }


    @GetMapping("/getCommits/{gitId}")
    public Response getCommits(@PathVariable Integer gitId,String branch) {
        List<GitlabBranchesVo> gitlabBranchesVos = jacocoServer.getCommits(gitId,branch);
        return Response.success(gitlabBranchesVos);
    }


    @PostMapping("/list")
    public Response list(Jacoco query, String orderBy, PageRequest pageRequest) {
        if (pageRequest.needPaging()) {
            PagedData<Jacoco> pagedData = jacocoServer.list(query, orderBy, pageRequest);
            return Response.success(pagedData);
        } else {
            List<Jacoco> projectVos = jacocoServer.getJacoco(query, orderBy);
            return Response.success(projectVos);
        }
    }

    @PostMapping("/delete")
    public Response delete(@RequestBody List<Integer> ids) {
        jacocoServer.delete(ids);
        return Response.success("删除成功");
    }
}
