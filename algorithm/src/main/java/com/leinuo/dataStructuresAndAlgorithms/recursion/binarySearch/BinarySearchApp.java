package com.leinuo.dataStructuresAndAlgorithms.recursion.binarySearch;


/**
 * Create by leinuo on 2020/2/24 下午4:08
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 *
 * 递归实现二分查找
 */
public class BinarySearchApp {
    public static void main(String[] args) {
        int maxSize = 100;
        OrdArray ordArray = new OrdArray(maxSize);
        ordArray.insert(89);
        ordArray.insert(56);
        ordArray.insert(61);
        ordArray.insert(34);
        ordArray.insert(32);
        ordArray.insert(78);
        ordArray.insert(98);
        ordArray.insert(12);
        ordArray.insert(45);
        ordArray.insert(77);
        ordArray.insert(28);
        ordArray.insert(99);
        ordArray.insert(111);
        ordArray.insert(50);
        ordArray.insert(103);
        ordArray.insert(88);
        ordArray.display();
        ordArray.insert(3);
        ordArray.display();
        int key = 66;
        int result = ordArray.find(66);
        if(result==ordArray.size()){
            System.out.println("no result for key:"+key);
            return;
        }
        System.out.println("result:" + result);
    }

}
