package com.leinuo.sort.link;

/**
 * Create by leinuo on 2020/2/21 上午10:06
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class LinkStackApp {
    public static void main(String[] args) {
        LinkStack linkStack = new LinkStack();
        System.out.println(linkStack.pop());
        linkStack.push(1,1.1);
        linkStack.push(2,2.1);
        linkStack.push(3,3.1);
        linkStack.display();
        System.out.println(linkStack.pop());
        System.out.println(linkStack.pop());
        linkStack.display();
    }
}
