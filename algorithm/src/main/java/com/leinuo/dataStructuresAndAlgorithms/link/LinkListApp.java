package com.leinuo.dataStructuresAndAlgorithms.link;

/**
 * Create by leinuo on 2020/2/17 下午4:51
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class LinkListApp {
    public static void main(String[] args) {
        LinkList linkList = new LinkList();
        Link link;
        int a;double d;
        System.out.println("add data");
        /*for(int i = 0;i<10;i++){
            a = new Random().nextInt(100);
            d = new Random().nextDouble();
            d = Double.valueOf(String.format("%.2f", d));
            linkList.insertFirst(a,d);
        }*/
        linkList.insertFirst(2,2.22);
        linkList.insertFirst(3,3.33);
        linkList.insertFirst(1,1.11);
        linkList.insertFirst(9,9.22);
        linkList.insertFirst(6,6.22);
        linkList.insertFirst(7,7.22);
        link = linkList.find(3);
        link.display();
        System.out.println("remove data 3");
        link = linkList.delete(3);
        link.display();
        System.out.println("after remove data 3");
        linkList.displayList();
        linkList.deleteFirst();
       // link.display();
        System.out.println("after deleteFirst");
        linkList.displayList();
        System.out.println("remove data");
        while(!linkList.isEmpty()){
            link = linkList.deleteFirst();
            link.display();
        }
        System.out.println("display data after remove data");
        linkList.displayList();
    }
}
