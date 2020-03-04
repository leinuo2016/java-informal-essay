package com.leinuo.dataStructuresAndAlgorithms.recursion;

/**
 * Create by leinuo on 2020/2/26 上午11:49
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class RecursionApp {

    static int count = 1;


    public static void main(String[] args) {
        //x^y
        //int result = power(2, 6, 2);
        int result1 = power(3, 18);
        System.out.println(result1);
        int[] array = new int[5];
        array[0]=11;
        array[1]=8;
        array[2]=7;
        array[3]=6;
        array[4]=5;
        backpack(array,0,26,26);
    }



    //求乘方
    private static int power(int x, int y) {
        System.out.println(String.format("x=%s,y=%s", x, y));
        if(y==1){
            return x*count;
        }else {
            int x1 = x*x;
            int y1 = y/2;
            if(y%2 != 0){
                count = count*x;
            }
            return power(x1,y1);
         //   return power(x,y);
        }
    }

    //背包问题
    private static boolean backpack(int[] array,int start,int left,int sum){
        if(start==array.length){
        int[] tempArr = new int[array.length-1];
        for(int i=0;i<tempArr.length;i++){
            tempArr[i] = array[i+1];
        }
        return backpack(tempArr,0,sum,sum);
        }else if(array[start]>left){
            return backpack(array,start+1,left,sum);
        }else if(array[start]==left){
            for(int i=0;i<start+1;i++){
                System.out.print(array[i]+" ");
            }
            return true;
        }else {
            return backpack(array,start+1,left-array[start],sum);
        }

    }
}
