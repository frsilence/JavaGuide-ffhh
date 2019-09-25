package cn.ffhh.proxy.DynamicProxy;

/**
 * Created with IntelliJ IDEA.
 * User: yfzhao
 * Date: 2019/9/25
 * Time: 22:07
 * Description: No Description
 */
public class Student implements Person{
    @Override
    public void work() {
        System.out.println("Student is study");
    }
}
