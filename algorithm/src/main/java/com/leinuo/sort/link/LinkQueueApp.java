package com.leinuo.sort.link;

/**
 * Create by leinuo on 2020/2/21 上午10:24
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class LinkQueueApp {
    public static void main(String[] args) {
        LinkQueue linkQueue = new LinkQueue();
        System.out.println(linkQueue.remove());
        linkQueue.insert(1,1.1);
        linkQueue.insert(2,2.1);
        linkQueue.insert(3,3.1);
        linkQueue.display();
        System.out.println(linkQueue.remove());
        linkQueue.display();
    }
}
