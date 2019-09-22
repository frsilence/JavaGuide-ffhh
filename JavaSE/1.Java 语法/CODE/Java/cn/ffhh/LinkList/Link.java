package cn.ffhh.LinkList;

/**
 * Created with IntelliJ IDEA.
 * User: yfzhao
 * Date: 2019/9/21
 * Time: 17:07
 * Description: 一个链表类
 */
public class Link<T> {
    private Node<T> root;//根节点
    private int count = 0;
    private int foot  = 0;//当期元素编号
    //增加节点
    public void add(T data){
        if(data == null){
            return;
        }
        Node<T> newNode = new Node<T>(data);
        if(this.root==null){
            this.root = newNode;
        }else{
            this.root.addNode(newNode);
        }
        this.count++;
    }
    //获得链表长度
    public int size(){
        return this.count;
    }
    //判断链表是否为空
    public boolean isEmpty(){
        return this.count==0;
    }
    //查询某一数据是否存在于当前链表
    public boolean contains(T data){
        if(data==null||this.root==null){
            return false;
        }
        return this.root.containNode(data);
    }
    //根据索引取得数据
    public T get(int index){
        if(this.count<index){
            return null;
        }
        this.foot = 0;
        return this.root.getNode(index);

    }
    //根据索引修改相应数据
    public void setNode(int index,T data){
        if(this.count<index){
            return;
        }
        this.foot = 0;
        this.root.setNode(index,data);
    }
    //删除节点
    public void remove(T data){
        if(this.contains(data)){
           if(data.equals(this.root.data)){
               this.root = this.root.next;
           }else{
               this.root.next.removeNode(this.root,data);
           }
        }
        this.count--;
    }
    //List转换为数组
    public T [] toArrary(T[] array){
        if(array.length<this.count){
            throw new RuntimeException("传入的数组长度小于被转换LINK的长度");
        }
        if(this.root==null){
            return null;
        }
        this.foot = 0;
        this.root.toArrayNode(array);
        return array;
    }
    //打印节点
    public void print(){
        if(this.root!=null){
            this.root.printNode();
        }
    }
    //定义内部类Node，服务于Link类
    private class Node<T>{
        private T data;//节点数据
        private Node<T> next;//下一节点
        public Node(T data) {
            this.data = data;
        }
        public Node getNext() {
            return next;
        }
        public void setNext(Node next) {
            this.next = next;
        }
        public T getData() {
            return data;
        }
        public void addNode(Node newNode){
            if(this.next==null){
                this.next = newNode;
            }else{
                this.next.addNode(newNode);
            }
        }
        public void printNode(){
            System.out.println(this.data);
            if(this.next!=null){
                this.next.printNode();
            }
        }

        public boolean containNode(T data) {
            if(this.data.equals(data)){
                return true;
            }else{
                if(this.next==null){
                    return false;
                }else{
                    return this.next.containNode(data);
                }
            }
        }

        public T getNode(int index) {
            if(Link.this.foot++==index){
                return this.getData();
            }else{
                return this.next.getNode(index);
            }
        }

        public void setNode(int index, T data) {
            if(Link.this.foot++==index){
                this.data=data;
            }else{
                this.next.setNode(index,data);
            }
        }

        public void removeNode(Node<T> previousNode, T data) {
            if(data.equals(this.data)){
                previousNode.next = this.next;
            }else{
                this.next.removeNode(this,data);
            }
        }

        public void toArrayNode(T [] array) {
            array[Link.this.foot++] = this.data;
            if(this.next!=null){
                this.next.toArrayNode(array);
            }
        }
    }
}
