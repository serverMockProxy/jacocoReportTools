package com.apiProxy.typehandler;


import com.apiProxy.mbg.po.JacocoConfig;

/**
 * @Author：hem
 * @Date：10/25/20 4:57 下午
 */
public class JacocoConfigListTypeHandler extends ListTypeHandler {
    @Override
    public Class getTypeClass() {
        return JacocoConfig.class;
    }
}
