package cn.ffhh.proxy.StaticProxy;

/**
 * @auther FrSilence
 * @date 2019-09-25 16:50
 */
public class Student implements Person {

    @Override
    public void work() {
        System.out.println("Student is study");
    }
}
