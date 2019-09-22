package cn.ffhh.LinkList;

/**
 * Created with IntelliJ IDEA.
 * User: yfzhao
 * Date: 2019/9/21
 * Time: 19:22
 * Description: No Description
 */
public class Test {
    public static void main(String[] args) {
        Link<String> stringLink = new Link<String>();
        stringLink.add("a");
        stringLink.add("b");
        stringLink.add("c");
        stringLink.remove("b");
        stringLink.print();
        System.out.println(stringLink.size());
        System.out.println(stringLink.contains("a"));
        String [] arr = stringLink.toArrary(new String[stringLink.size()]);
        System.out.println(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println((String) arr[i]);
        }
    }
}
