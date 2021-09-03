package com.apiProxy.model;

import lombok.Data;

/**
 * @Author：hem
 * @Date：6/23/21 8:39 下午
 */
@Data
public class GitlabProject {
    private Integer id;
    private String name;
    private String path;
    private String ssh_url_to_repo;
    private String http_url_to_repo;
    private String web_url;
    private String path_with_namespace;
}
