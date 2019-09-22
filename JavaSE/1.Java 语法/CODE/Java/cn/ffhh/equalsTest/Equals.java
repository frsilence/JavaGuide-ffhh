package cn.ffhh.equalsTest;

/**
 * Created with IntelliJ IDEA.
 * User: yfzhao
 * Date: 2019/9/22
 * Time: 15:39
 * Description: No Description
 */
public class Equals {
    private String name;
    private Integer id;
    //自定义类重写equals
    @Override
    public boolean equals(Object obj) {
        if(this==obj){
            return true;
        }
        if(obj==null){
            return false;
        }
        if(!(obj instanceof Equals)){
            return false;
        }
        Equals equals = (Equals) obj;
        if(this.name.equals(equals.name)&&this.id==equals.id){
            return true;
        }
        return false;
    }
}
