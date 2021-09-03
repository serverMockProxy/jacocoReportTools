package com.apiProxy.typehandler;


import com.apiProxy.mbg.po.Jacoco;

/**
 * @Author：hem
 * @Date：10/25/20 4:57 下午
 */
public class JacocoListTypeHandler extends ListTypeHandler {
    @Override
    public Class getTypeClass() {
        return Jacoco.class;
    }
}
