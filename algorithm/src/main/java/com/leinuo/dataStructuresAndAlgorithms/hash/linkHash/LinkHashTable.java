package com.leinuo.dataStructuresAndAlgorithms.hash.linkHash;

/**
 * Create by leinuo on 2020/3/3 上午10:35
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class LinkHashTable {
    private SortedList[] hashArray;
    private int arraySize;


    public LinkHashTable(int size){
        arraySize = size;
        hashArray = new SortedList[arraySize];
        for (int i = 0; i <size ; i++) {
            hashArray[i] = new SortedList();
        }
    }

    public void display(){
        System.out.println("Table:");
        for (int j = 0; j < arraySize; j++) {
            System.out.print(j+". ");
            hashArray[j].display();
        }
        System.out.println(" ");
    }

    //第一次哈希算法
    private int hashFunc(int key){
        return key%arraySize;
    }


    public void insert(Link link){
        int key = link.getKey();
        int hashVal = hashFunc(key);
        hashArray[hashVal].insert(link);
    }

    public void delete(int key){
        int hashVal = hashFunc(key);
        hashArray[hashVal].delete(key);
    }

    public Link find(int key){
        int hashVal = hashFunc(key);
        return hashArray[hashVal].find(key);
    }
}
