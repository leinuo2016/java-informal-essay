package com.leinuo.dataStructuresAndAlgorithms.recursion.mergeSort;

import java.util.Arrays;

/**
 * Create by leinuo on 2020/2/25 上午11:28
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 *
 * 归并排序
 */
public class MergeApp {
    public static void main(String[] args) {
        int[] arrayA = {12,19,45,65,78};
        int[] arrayB = {15,34,43,77};
        int[] arrayC = new int[arrayA.length+arrayB.length];
        merge(arrayA,5,arrayB,4,arrayC);
        Arrays.stream(arrayC).forEach(array->System.out.println(array));
    }
    private static void merge(int[] arrayA, int sizeA, int[] arrayB, int sizeB, int[] arrayC) {
        int indexA=0,indexB=0,indexC=0;
        while (indexA<sizeA&&indexB<sizeB){
            if(arrayA[indexA]<arrayB[indexB]){
                arrayC[indexC++] = arrayA[indexA++];
            }else {
                arrayC[indexC++] = arrayB[indexB++];
            }
        }
        while (indexA<sizeA){
            arrayC[indexC++] = arrayA[indexA++];
        }

        while (indexB<sizeB){
            arrayC[indexC++] = arrayB[indexB++];
        }
    }
}
