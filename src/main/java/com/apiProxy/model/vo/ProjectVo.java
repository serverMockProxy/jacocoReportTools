package com.apiProxy.model.vo;

import com.apiProxy.mbg.po.Project;
import lombok.Data;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@Data
public class ProjectVo extends Project {
    private String creatorNickName = "";
}
