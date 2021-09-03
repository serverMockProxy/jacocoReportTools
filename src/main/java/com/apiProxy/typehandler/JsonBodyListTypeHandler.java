package com.apiProxy.typehandler;


import com.apiProxy.model.JsonBody;

/**
 * @Author：hem
 * @Date：10/25/20 4:57 下午
 */
public class JsonBodyListTypeHandler extends ListTypeHandler {
    @Override
    public Class getTypeClass() {
        return JsonBody.class;
    }
}
