package com.leinuo.dataStructuresAndAlgorithms.recursion.binarySearch;

/**
 * Create by leinuo on 2020/2/24 下午3:55
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class OrdArray {
    private int[] ints;
    private int nElems;

    public OrdArray(int max) {
        ints = new int[max];
        nElems = 0;
    }

    public int size() {
        return nElems;
    }

    public int find(int key) {
        return recFind(key, 0, nElems - 1);
    }

    private int recFind(int key, int lowerBound, int upperBound) {
        int curIn;
        curIn = (lowerBound + upperBound) / 2;
        if (ints[curIn] == key) {
            return curIn;
        } else if (lowerBound > upperBound) {
            return nElems;
        } else {
            if (ints[curIn] < key) {
                return recFind(key, curIn + 1, upperBound);
            } else {
                return recFind(key, lowerBound, curIn - 1);
            }
        }
    }

    public void insert(int value) {
        int i;
        for (i = 0; i < nElems; i++)
            if (ints[i] > value)
                break;
        for (int k = nElems; k > i; k--)
            ints[k] = ints[k - 1];
        ints[i] = value;
        nElems++;
    }

    public void display() {
        for (int i : ints) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
