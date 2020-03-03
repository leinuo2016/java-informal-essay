package com.leinuo.sort.hash;

import java.util.Objects;

/**
 * Create by leinuo on 2020/3/3 上午10:35
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class HashTable {
    private DataItem[] hashArray;
    private int arraySize;
    private DataItem nonItem;

    public HashTable(int size){
        arraySize = size;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem(-1);
    }

    public void display(){
        System.out.println("Table:");
        for (int j = 0; j < arraySize; j++) {
            if(Objects.nonNull(hashArray[j]))
                System.out.print(hashArray[j].getKey()+" ");
            else
                System.out.print("** ");
        }
        System.out.println(" ");
    }

    //第一次哈希算法
    private int hashFunc(int key){
        return key%arraySize;
    }
    //再哈希法
    private int hashFunc2(int key){
        return 5-(key%5);
    }

    public void insert(DataItem item){
        int key = item.getKey();
        int hashVal = hashFunc(key);
        int stepSize = hashFunc2(key);
        while (Objects.nonNull(hashArray[hashVal])&&hashArray[hashVal].getKey()!=-1){
            hashVal +=stepSize;
            hashVal%=arraySize;
        }
        hashArray[hashVal] = item;
    }

    public DataItem delete(int key){
        int hashVal = hashFunc(key);
        int stepSize = hashFunc2(key);
        while (Objects.nonNull(hashArray[hashVal])){
            if(hashArray[hashVal].getKey()==key){
                DataItem temp = hashArray[hashVal];
                hashArray[hashVal] = nonItem;
                return temp;
            }
            hashVal +=stepSize;
            hashVal%=arraySize;
        }
        return null;
    }

    public DataItem find(int key){
        int hashVal = hashFunc(key);
        int stepSize = hashFunc2(key);
        while (Objects.nonNull(hashArray[hashVal])){
            if(hashArray[hashVal].getKey()==key){
                return hashArray[hashVal];
            }
            hashVal +=stepSize;
            hashVal%=arraySize;
        }
        return null;
    }
}
