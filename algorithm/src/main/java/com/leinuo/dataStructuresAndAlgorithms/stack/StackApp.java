package com.leinuo.dataStructuresAndAlgorithms.stack;

/**
 * Create by leinuo on 2020/2/7 下午4:21
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class StackApp {

    public static void main(String[] args) {
        Stackx stackx = new Stackx(7);
        stackx.push(1);
        stackx.push(2);
        stackx.push(3);
        stackx.push(4);
        stackx.push(5);
        stackx.push(6);
        stackx.push(7);
        long value;
        while (!stackx.isEmpty()){
            value = stackx.peek();
            System.out.println(value);
            value = stackx.pop();
            System.out.println(value);
        }
    }
}
