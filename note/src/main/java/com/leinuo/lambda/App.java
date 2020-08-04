package com.leinuo.lambda;

import java.util.Arrays;

/**
 * Create by leinuo on 2020/8/4
 * qq:1321404703 https://github.com/leinuo2016
 */
public class App {
    public static void main(String[] args) {

        //接口或类只有一个抽象方法,lambda就可以匿名内部类的方式表示为lambda表达式
        MyLambdaIpm myLambdaIpm = new MyLambdaIpm();
        myLambdaIpm.test(new MyLambda() {
            @Override
            public void test(MyLambdaIpm m) {
            }
        });
        myLambdaIpm.test(myLambda -> System.out.println("args = "));

        //MyComparator myComparator = (a,b) -> {return a>b;};
        MyComparator myComparator = (a,b) ->  a>b;
        boolean resullt = myComparator.compare(2,5);
        System.out.println(resullt);
    }



}
