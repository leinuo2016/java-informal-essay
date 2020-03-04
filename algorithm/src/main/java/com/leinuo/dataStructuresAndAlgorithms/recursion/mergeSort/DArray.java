package com.leinuo.dataStructuresAndAlgorithms.recursion.mergeSort;

import java.util.Arrays;

/**
 * Create by leinuo on 2020/2/25 下午2:39
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class DArray {
    private int[] theArray;
    private int nElems;

    public DArray(int max){
        theArray = new int[max];
        nElems = 0;
    }

    public void insert(int value){
        theArray[nElems]=value;
        nElems++;
    }

    public void display(){
        Arrays.stream(theArray).forEach(array->System.out.print(array+" "));
        System.out.println(" ");
    }

    public void mergeSort(){
        int[] result = new int[nElems];
        recMergeSort(result,0,nElems-1);
    }

    private void recMergeSort(int[] result, int lowerBound, int upperBound) {
        if(lowerBound==upperBound){
            return;
        }else {
            int mid = (lowerBound+upperBound)/2;
            recMergeSort(result,lowerBound,mid);
            recMergeSort(result,mid+1,upperBound);
            merge(result,lowerBound,mid+1,upperBound);
        }
        
    }

    private void merge(int[] result, int lowPtr, int highPtr, int upperBound) {
        int j=0;
        int lowerBound = lowPtr;
        int mid = highPtr-1;
        int n = upperBound-lowerBound+1;
        while (lowPtr<=mid&&highPtr<=upperBound){
            if(theArray[lowPtr]<theArray[highPtr]){
                result[j++] = theArray[lowPtr++];
            }else {
                result[j++] = theArray[highPtr++];
            }
        }

        while (lowPtr<=mid){
            result[j++] = theArray[lowPtr++];
        }

        while (highPtr<=upperBound){
            result[j++] = theArray[highPtr++];
        }

        for(j=0;j<n;j++){
            theArray[lowerBound+j] = result[j];
        }
    }

    public static void main(String[] args) {
        DArray dArray = new DArray(9);
        dArray.insert(88);
        dArray.insert(100);
        dArray.insert(77);
        dArray.insert(89);
        dArray.insert(23);
        dArray.insert(43);
        dArray.insert(66);
        dArray.insert(45);
        dArray.insert(55);
        dArray.display();
        dArray.mergeSort();
        dArray.display();
    }
}
