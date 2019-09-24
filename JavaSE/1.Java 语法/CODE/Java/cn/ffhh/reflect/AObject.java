package cn.ffhh.reflect;

/**
 * @auther FrSilence
 * @date 2019-09-24 11:09
 */
public class AObject {
    private String name;

    public AObject() {
    }

    public AObject(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }
     public void fun(int id){
         System.out.println("fun()...running"+id);
     }
}
