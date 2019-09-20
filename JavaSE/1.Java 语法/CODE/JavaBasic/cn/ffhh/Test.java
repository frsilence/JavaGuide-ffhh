package cn.ffhh;

import java.util.Arrays;

/**
 * @auther FrSilence
 * @date 2019-09-20 14:15
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(jiecheng(5));
        //Arrays.sort();
    }
    public static Integer jiecheng(Integer n){
        if(n==1){
            return 1;
        }else{
            return n*jiecheng(n-1);
        }
    }
}
