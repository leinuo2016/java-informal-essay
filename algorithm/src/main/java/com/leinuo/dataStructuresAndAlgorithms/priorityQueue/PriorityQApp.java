package com.leinuo.dataStructuresAndAlgorithms.priorityQueue;

/**
 * Create by leinuo on 2020/2/9 下午8:19
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class PriorityQApp {

    public static void main(String[] args) {
        PriorityQ priorityQ = new PriorityQ(6);

        priorityQ.insert(100);

        priorityQ.insert(99);

        priorityQ.insert(100);

        priorityQ.insert(77);

        priorityQ.insert(34);

        priorityQ.insert(22);

        long value;
        while (!priorityQ.isEmpty()){
            value = priorityQ.peekMin();
            System.out.println("peekMin:" +value);
            value = priorityQ.remove();
            System.out.println("remove:" +value);
        }
    }
}
