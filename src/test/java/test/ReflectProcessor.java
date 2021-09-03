package test;

import java.lang.reflect.Method;

/**
 * @Author：hem
 * @Date：10/19/20 7:20 下午
 */
public class ReflectProcessor {
    public void parseMethod(Class<?> clazz) throws Exception{
        Object obj = clazz.getConstructor(new Class[] {}).newInstance(new Object[] {});
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method:methods){
            Reflect my = method.getAnnotation(Reflect.class);
            if (null != my){
                method.invoke(obj,my.name());
            }
        }
    }

    public static void main(String[] args) {
        String a = "/fsdf/proxy/afsdf";
        System.out.println(a.substring(1));
        String[] c = a.split("/proxy");
        for (String b :c){
            System.out.println(b);
        }
    }
}
