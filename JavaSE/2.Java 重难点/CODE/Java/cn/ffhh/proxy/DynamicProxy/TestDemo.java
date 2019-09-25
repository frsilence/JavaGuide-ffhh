package cn.ffhh.proxy.DynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created with IntelliJ IDEA.
 * User: yfzhao
 * Date: 2019/9/25
 * Time: 22:18
 * Description: No Description
 */
public class TestDemo {
    public static void main(String[] args) {
        Person student = new Student();
        //产生与被代理类相关的InvocationHandler
        InvocationHandler studentHandler = new StuInvocationHandler<Person>(student);
        //产生动态代理类
        Person studentProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),new Class[]{Person.class},studentHandler);
        studentProxy.work();

        //2
        Person techer = new Teacher();
        InvocationHandler techerHandler = new StuInvocationHandler<Person>(techer);
        Person techerProxy = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(),new Class[]{Person.class},techerHandler);
        techerProxy.work();
    }




}
