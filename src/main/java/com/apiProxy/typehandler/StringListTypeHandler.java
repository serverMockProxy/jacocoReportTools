package com.apiProxy.typehandler;

/**
 * @Author：hem
 * @Date：5/27/21 5:26 下午
 */
public class StringListTypeHandler extends ListTypeHandler {
    @Override
    public Class getTypeClass() {
        return String.class;
    }
}
