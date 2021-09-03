package com.apiProxy.typehandler;


import com.apiProxy.model.QueryBodys;

/**
 * @Author：hem
 * @Date：10/25/20 4:58 下午
 */
public class QueryBodyListTypeHandler extends ListTypeHandler {
    @Override
    public Class getTypeClass() {
        return QueryBodys.class;
    }
}
