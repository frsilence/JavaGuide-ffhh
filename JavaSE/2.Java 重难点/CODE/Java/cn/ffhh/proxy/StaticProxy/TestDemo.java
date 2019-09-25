package cn.ffhh.proxy.StaticProxy;

/**
 * Created with IntelliJ IDEA.
 * User: yfzhao
 * Date: 2019/9/25
 * Time: 21:50
 * Description: No Description
 */
public class TestDemo {
    public static void main(String[] args) {
        Person myStudent = new StaticProxy(new Student());
        myStudent.work();
    }
}
