package com.apiProxy.controller;

import com.apiProxy.mbg.po.Project;
import com.apiProxy.model.PageRequest;
import com.apiProxy.model.PagedData;
import com.apiProxy.model.Response;
import com.apiProxy.model.vo.ProjectVo;
import com.apiProxy.service.ProjectService;
import com.apiProxy.validator.UpdateGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@RestController
@RequestMapping("/project")
@Slf4j
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @PostMapping("/add")
    public Response add(@Valid @RequestBody Project project) {
        projectService.add(project);
        return Response.success("添加成功");
    }

    @DeleteMapping("/{projectId}")
    public Response delete(@PathVariable Integer projectId) {
        projectService.delete(projectId);
        return Response.success("删除成功");
    }

    @PostMapping("/update")
    public Response update(@Validated({UpdateGroup.class}) @RequestBody Project project) {
        projectService.update(project);
        return Response.success("更新成功");
    }

    @PostMapping("/list")
    public Response list(Project query, String orderBy, PageRequest pageRequest) {
        if (pageRequest.needPaging()) {
            PagedData<ProjectVo> pagedData = projectService.list(query, orderBy, pageRequest);
            return Response.success(pagedData);
        } else {
            List<ProjectVo> projectVos = projectService.getProjectVos(query, orderBy);
            return Response.success(projectVos);
        }
    }
}
