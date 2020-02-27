package com.leinuo.sort.advancedSort.quickSort;

import java.util.Arrays;

/**
 * Create by leinuo on 2020/2/27 上午11:38
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class ArrayPar3 {
    private int[] theArray;
    private int nElems;

    public ArrayPar3(int maxSize) {
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
        int size = right-left+1;
        //size小于10使用插入排序
        if(size<10){
            insertionSort(left,right);
        }else {
            int median = medianOf3(left,right);
           // System.out.printf("median=%d,value=%s%n", median, theArray[median]);
            int partition = partitionIt(left,right,median);
            //System.out.printf("partition=%d,value=%s%n", partition, theArray[partition]);
            recQuicSort(left,partition-1);
            recQuicSort(partition+1,right);
        }
    }

    private void insertionSort(int left, int right) {
        int in,out;
        for(out=left+1;out<=right;out++){
            int temp = theArray[out];
            in=out;
            while (in>left&&theArray[in-1]>=temp){
                theArray[in] = theArray[in-1];
                --in;
            }
            theArray[in]=temp;
        }
    }


    //三数据项取中
    public int medianOf3(int left,int right){
        int current = (right+left)/2;
        if(theArray[left]>theArray[current]){
            swap(left,current);
        }
        if(theArray[left]>theArray[right]){
            swap(left,right);
        }
        if(theArray[current]>theArray[right]){
            swap(current,right);
        }
        swap(current,right-1);
        return theArray[right-1];
    }

    public int partitionIt(int left, int right, int pivot) {
        int leftPtr = left;
        int rightPtr = right - 1;
        while (true) {
            while (theArray[++leftPtr] < pivot) ;
            while (theArray[--rightPtr] > pivot) ;
            if (leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr, rightPtr);
        }
        swap(leftPtr,right-1);
        return leftPtr;
    }

    private void swap(int leftPtr, int rightPtr) {
        int temp;
        temp = theArray[leftPtr];
        theArray[leftPtr] = theArray[rightPtr];
        theArray[rightPtr] = temp;
    }


}
