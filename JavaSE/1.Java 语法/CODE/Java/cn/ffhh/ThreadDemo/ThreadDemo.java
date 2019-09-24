package cn.ffhh.ThreadDemo;

/**
 * @auther FrSilence
 * @date 2019-09-24 14:53
 */
public class ThreadDemo {
    public static void main(String[] args) {
        //1
        Thread myThread1 = new Mythread();
        myThread1.setPriority(1);//设置优先级，优先级设置范围：1-10


        //2
        Thread myThread2 = new Thread(new Mythread2());
        myThread2.setPriority(10);

        //start
        myThread1.start();
        myThread2.start();
    }
};
//多线程实现1：继承Thread类
class Mythread extends Thread{
    @Override
    public void run() {
        for (int i=0;i<10;i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyThread1");
        }
    }
}
//多线程实现2：实现Runnable接口
class Mythread2 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("MyThread2");
        }
    }
}