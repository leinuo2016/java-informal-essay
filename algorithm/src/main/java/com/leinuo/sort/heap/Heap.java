package com.leinuo.sort.heap;

import java.util.Objects;

/**
 * Create by leinuo on 2020/3/3 下午5:19
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;

    public Heap(int maxSize) {
        this.maxSize = maxSize;
        currentSize = 0;
        heapArray = new Node[maxSize];
    }

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean insert(int key) {
        if (currentSize == maxSize) {
            return false;
        }
        Node newNode = new Node(key);
        heapArray[currentSize] = newNode;
        trickleUp(currentSize++);
        return true;
    }

    public void trickleUp(int index) {
        int parent = (index - 1) / 2;
        Node bottom = heapArray[index];
        while (index > 0 && heapArray[parent].getKey() < bottom.getKey()) {
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = (parent - 1) / 2;
        }
        heapArray[index] = bottom;
    }

    public Node remove() {
        Node root = heapArray[0];
        heapArray[0] = heapArray[--currentSize];
        trickleDown(0);
        return root;
    }

    public void trickleDown(int index) {
        int larderChild;
        Node top = heapArray[index];
        while (index < currentSize / 2) {
            int leftChild = 2 * index + 1;
            int rightChild = leftChild + 1;
            if (rightChild < currentSize && heapArray[leftChild].getKey() < heapArray[rightChild].getKey())
                larderChild = rightChild;
            else
                larderChild = leftChild;
            if (top.getKey() >= heapArray[larderChild].getKey())
                break;
            heapArray[index] = heapArray[larderChild];
            index = larderChild;
        }
        heapArray[index] = top;
    }

    public boolean change(int index, int newValue) {
        if (index < 0 || index >= currentSize)
            return false;
        int oldValue = heapArray[index].getKey();
        heapArray[index].setKey(newValue);
        if (oldValue < newValue)
            trickleUp(index);
        else
            trickleDown(index);
        return true;
    }

    public void display() {
        System.out.print("heapArray: ");
        for (int m = 0; m < currentSize; m++) {
            if (Objects.nonNull(heapArray[m]))
                System.out.print(heapArray[m].getKey() + " ");
            else
                System.out.print("-- ");
        }
        System.out.println("-- ");
        int nBlanks = 32;
        int itemsPreRow = 1;
        int column = 0;
        int j = 0;
        String dots = ".......................";
        System.out.println(dots + dots);
        while (currentSize > 0) {
            if (column == 0)
                for (int k = 0; k < nBlanks; k++)
                    System.out.print(' ');
            System.out.print(heapArray[j].getKey());
            if (++j == currentSize)
                break;
            if (++column == itemsPreRow) {
                nBlanks /= 2;
                itemsPreRow *= 2;
                column = 0;
                System.out.println();
            } else
                for (int k = 0; k < nBlanks * 2 - 2; k++)
                    System.out.print(' ');
        }
        System.out.println("\n" + dots + dots);
    }

    public void displayArray() {
        System.out.print("Array: ");
        for (int m = 0; m < maxSize; m++) {
                System.out.print(heapArray[m].getKey() + " ");
        }
    }

    public void incrementSize(){
        currentSize++;
    }

    public void insertAt(int index,Node newNode){
        heapArray[index]=newNode;
    }

}
