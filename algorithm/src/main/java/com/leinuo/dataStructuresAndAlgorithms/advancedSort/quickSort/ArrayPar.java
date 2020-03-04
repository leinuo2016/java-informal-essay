package com.leinuo.dataStructuresAndAlgorithms.advancedSort.quickSort;

import java.util.Arrays;

/**
 * Create by leinuo on 2020/2/27 上午11:38
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class ArrayPar {
    private int[] theArray;
    private int nElems;

    public ArrayPar(int maxSize) {
        theArray = new int[maxSize];
        nElems = 0;
    }

    public void insert(int valve) {
        theArray[nElems] = valve;
        nElems++;
    }

    public void display() {
        Arrays.stream(theArray).forEach(array -> System.out.print(array + " "));
        System.out.println(" ");
    }

    public int size() {
        return nElems;
    }

    public int get(int index) {
        if (index > size()) {
            return 0;
        }
        return theArray[index];
    }

    public void quickSort(){
        recQuicSort(0,nElems-1);
    }

    private void recQuicSort(int left, int right) {
        if(right-left<=0){
            return;
        }else {
            int pivot = theArray[right];
            int partition = partitionIt(left,right,pivot);
           // System.out.printf("partDex=%d,value=%s%n", partition, theArray[partition]);
            recQuicSort(left,partition-1);
            recQuicSort(partition+1,right);
        }
    }

    public int partitionIt(int left, int right, int pivot) {
        int leftPtr = left - 1;
        int rightPtr = right + 1;
        while (true) {
            while (leftPtr < right && theArray[++leftPtr] < pivot) ;
            while (rightPtr > left && theArray[--rightPtr] > pivot) ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        return leftPtr;
    }

    private void swap(int leftPtr, int rightPtr) {
        int temp;
        temp = theArray[leftPtr];
        theArray[leftPtr] = theArray[rightPtr];
        theArray[rightPtr] = temp;
    }


}
