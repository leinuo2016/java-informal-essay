package com.leinuo.sort.hash.linkHash;

import com.leinuo.sort.SystemInUtils;
import com.leinuo.sort.hash.DataItem;
import com.leinuo.sort.hash.HashTable;

import java.io.IOException;
import java.util.Objects;

/**
 * Create by leinuo on 2020/3/3 下午2:23
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class LinkHashApp {
    public static void main(String[] args) throws IOException {
        Link dataItem;
        int size,n,keyPerCell = 100;
        System.out.println("Enter size of hashTable:");
        size = SystemInUtils.getInt();
        LinkHashTable hashTable = new LinkHashTable(size);
        System.out.println("Enter initial  number of items:");
        n = SystemInUtils.getInt();
        int aKey;
        for (int j = 0; j < size; j++) {
            aKey = (int)(Math.random()*keyPerCell*size);
            dataItem = new Link(aKey);
            hashTable.insert(dataItem);
        }
        while (true){
            System.out.printf("Enter first letter of show,insert,find:");
            int choice = SystemInUtils.getChar();
            switch (choice){
                case 's':
                    hashTable.display();
                    break;
                case 'i':
                    System.out.println("Enter value to insert:");
                    aKey = SystemInUtils.getInt();
                    dataItem = new Link(aKey);
                    hashTable.insert(dataItem);
                    break;
                case 'd':
                    System.out.println("Enter value to delete:");
                    aKey = SystemInUtils.getInt();
                    hashTable.delete(aKey);
                    System.out.println("delete:"+aKey);
                    break;
                case 'f':
                    System.out.println("Enter value to find:");
                    aKey = SystemInUtils.getInt();
                    dataItem = hashTable.find(aKey);
                    if(Objects.nonNull(dataItem)){
                        System.out.println("Found:"+aKey);
                    }else {
                        System.out.println("not found:"+aKey);
                    }
                    break;
                case 'e':
                    System.exit(0);
                default:
                    System.out.println("no case");
            }
        }
    }
}