package com.apiProxy.typehandler;


import com.apiProxy.model.ApiHeaders;

/**
 * @Author：hem
 * @Date：10/25/20 4:54 下午
 */
public class ApiHeadersListTypeHandler extends ListTypeHandler {
    @Override
    public Class getTypeClass() {
        return ApiHeaders.class;
    }
}
