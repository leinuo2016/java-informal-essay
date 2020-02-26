package com.leinuo.sort.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create by leinuo on 2020/2/23 下午8:45
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class TriangleApp {

    public static void main(String[] args) throws IOException {
        while (true){
            System.out.println("enter a number:");
            int num = getNum();
            int result = triangle(num);
            System.out.println(String.format("triangle:%s",result));
            result = factorial(num);
            System.out.println(String.format("factorial:%s",result));
        }
    }

    //递归解三角数字
    public static int triangle(int n){
        if (n==1){
            return n;
        }else {
            return n+triangle(n-1);
        }
    }

    //递归解阶乘
    public static int factorial(int n){
        if (n==0){
            return 1;
        }else {
            return n*factorial(n-1);
        }
    }

    public  static  int getNum() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String a = bufferedReader.readLine();
        if(a.equals("exit")){
            System.exit(0);
        }
        return Integer.parseInt(a);
    }

}
