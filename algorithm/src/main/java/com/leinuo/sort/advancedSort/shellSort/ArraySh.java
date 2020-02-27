package com.leinuo.sort.advancedSort.shellSort;

import java.util.Arrays;

/**
 * Create by leinuo on 2020/2/26 下午4:17
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class ArraySh {
    private int[] theArray;
    private int nElems;
    public ArraySh(int max){
        theArray = new int[max];
        nElems=0;
    }

    public void insert(int valve){
        theArray[nElems] = valve;
        nElems++;
    }
    public void display(){
        Arrays.stream(theArray).forEach(array->System.out.print(array+" "));
        System.out.println(" ");
    }

    public void shellSort(){
        int inner,outer;
        int temp;
        int h = 1;
        while (h<=nElems/3){
            h = h*3+1;
        }
        while (h>0){
            for(outer=h;outer<nElems;outer++){
                temp = theArray[outer];
                inner=outer;
                while (inner>h-1&&theArray[inner-h]>=temp){
                    theArray[inner] = theArray[inner-h];
                    inner-=h;
                }
                theArray[inner] = temp;
            }
            h=(h-1)/3;
        }
    }
}
