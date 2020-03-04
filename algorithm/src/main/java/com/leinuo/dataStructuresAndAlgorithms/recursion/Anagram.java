package com.leinuo.dataStructuresAndAlgorithms.recursion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Create by leinuo on 2020/2/24 上午9:25
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Anagram {
    static int size;
    static int count;
    static char[] chars = new char[100];


    //递归解变位字
    public static void doAnagram(int newSize){
        if(newSize==1){
            return;
        }
        for (int i = 0; i < newSize; i++) {
            doAnagram(newSize-1);
            if(newSize==2){
                displayWord();
            }
            rotate(newSize);
        }
    }

    public static void main(String[] args) throws IOException {
        while (true){
            System.out.println("enter a string:");
            String word = getString();
            size = word.length();
            count=0;
            for(int i=0;i<size;i++){
                chars[i] = word.charAt(i);
            }
            doAnagram(size);
        }
    }

    public  static  String getString() throws IOException {
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String string = bufferedReader.readLine();
        if(string.equals("exit")){
            System.exit(0);
        }
        return string;
    }

    public static void rotate(int newSize){
        int i;
        int position = size-newSize;
        char temp = chars[position];
        for (i=position+1;i<size;i++){
            chars[i-1] = chars[i];
        }
        chars[i-1] = temp;
    }

    public static void displayWord(){
        if(count<99){
            System.out.print(" ");
        }
        if(count<9){
            System.out.print(" ");
        }
        System.out.print(++count+" ");
        for(int j=0;j<size;j++){
            System.out.print(chars[j]);
        }
        System.out.print(" ");
        System.out.flush();
        if(count%6==0){
            System.out.print(" ");
        }
    }
}
