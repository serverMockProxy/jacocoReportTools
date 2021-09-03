package com.apiProxy.model;

import lombok.Data;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@Data
public class PageRequest {

    private Integer pageNum;
    private Integer pageSize;

    /**
     * 是否要分页
     *
     * @return
     */
    public boolean needPaging() {
        return (pageNum != null && pageNum > 0) && (pageSize != null && pageSize > 0);
    }
}
