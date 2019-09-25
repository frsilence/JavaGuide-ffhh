package cn.ffhh.proxy.StaticProxy;

/**
 * @auther FrSilence
 * @date 2019-09-25 16:03
 * 静态代理例子
 */
public class StaticProxy implements Person {
    private Person student;

    public StaticProxy(Person student) {
        this.student = student;
    }

    @Override
    public void work() {
        System.out.println("增强Student.work()");
        this.student.work();
    }
}
