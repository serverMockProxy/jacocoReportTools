package com.apiProxy.model.dto;

import com.apiProxy.mbg.po.Project;
import com.apiProxy.mbg.po.UserProject;
import lombok.Data;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@Data
public class UserProjectDto extends UserProject {
    private Project project;
}
