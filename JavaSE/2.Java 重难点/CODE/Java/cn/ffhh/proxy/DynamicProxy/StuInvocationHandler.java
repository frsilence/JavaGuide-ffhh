package cn.ffhh.proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: yfzhao
 * Date: 2019/9/25
 * Time: 22:14
 * Description: No Description
 */
public class StuInvocationHandler<T> implements InvocationHandler {

    T target;

    public StuInvocationHandler(T target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("动态代理增强");
        Object result = method.invoke(target,args);
        return result;
    }
}
