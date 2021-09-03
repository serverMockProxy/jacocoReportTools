package test;

import com.apiProxy.mbg.po.Jacoco;
import com.apiProxy.utils.ReportGenerator;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.types.JavaTypeResolverDefaultImpl;

import java.io.IOException;

public class MyJavaTypeResolver extends JavaTypeResolverDefaultImpl {
    /**
     * 将tinyint转换为Integer
     */
    public MyJavaTypeResolver() {
        super();
        super.typeMap.put(-6, new JdbcTypeInformation("TINYINT", new FullyQualifiedJavaType(Integer.class.getName())));
    }
}
