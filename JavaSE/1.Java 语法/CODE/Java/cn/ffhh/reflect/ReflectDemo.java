package cn.ffhh.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @auther FrSilence
 * @date 2019-09-24 11:04
 */
public class ReflectDemo {
    public static void main(String[] args) {
        Class clazz = AObject.class;
        Package packagee = clazz.getPackage();//获取类所在package
        System.out.println(packagee.getName());
        Constructor[] constructor = clazz.getDeclaredConstructors();//获取类所有构造方法
        Method[] method = clazz.getMethods();//获取权限为public的方法
        Field[] fields = clazz.getDeclaredFields();//获取全部成员变量

        //反射生成对象1
        try {
            Class clazz1 = Class.forName("cn.ffhh.reflect.AObject");
            AObject aObject = (AObject) clazz1.newInstance();
            aObject.fun(2);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //反射生成对象2
        try {
            Constructor constructor1 = clazz.getConstructor(String.class);
            AObject aObject2 = (AObject) constructor1.newInstance("abc");
            aObject2.fun(45);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //反射调用方法
        AObject aObject3 = new AObject("we");
        Method method3 = null;
        try {
            method3 = clazz.getMethod("fun", int.class);
            method3.invoke(aObject3,99999);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
