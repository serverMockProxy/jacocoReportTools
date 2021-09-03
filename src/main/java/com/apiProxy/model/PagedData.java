package com.apiProxy.model;

import lombok.Data;

import java.util.List;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
@Data
public class PagedData<T> {
    private long total;
    private List<T> data;

    public PagedData(List<T> data, long total) {
        this.data = data;
        this.total = total;
    }
}

