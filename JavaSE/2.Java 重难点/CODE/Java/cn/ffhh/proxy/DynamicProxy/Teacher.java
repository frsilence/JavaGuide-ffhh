package cn.ffhh.proxy.DynamicProxy;

/**
 * Created with IntelliJ IDEA.
 * User: yfzhao
 * Date: 2019/9/25
 * Time: 22:28
 * Description: No Description
 */
public class Teacher implements Person {
    @Override
    public void work() {
        System.out.println("Techer is Working");
    }
}
