package com.leinuo.dataStructuresAndAlgorithms.queue;

/**
 * Create by leinuo on 2020/2/9 上午11:14
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class QueueApp {

    public static void main(String[] args) {
        Queue queue = new Queue(3);
        queue.insert(2);
        queue.insert(3);
        queue.insert(4);
        queue.insert(5);
        queue.insert(6);
        queue.insert(7);

        long value;
        while (!queue.isEmpty()){
            value = queue.peekFront();
            System.out.println(value+"");
            value = queue.remove();
            System.out.println(value+"size:"+ queue.size());
        }
    }
}
