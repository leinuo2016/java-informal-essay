package com.leinuo.sort.tree.tree234;

import com.leinuo.sort.SystemInUtils;

import java.io.IOException;

/**
 * Create by leinuo on 2020/3/2 下午3:57
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Tree234App {
    public static void main(String[] args) throws IOException {
        long value;
        Tree234 tree234 = new Tree234();
        tree234.insert(50);
        tree234.insert(40);
        tree234.insert(60);
        tree234.insert(30);
        tree234.insert(70);
        while (true){
            System.out.printf("Enter first letter of show,insert,find:");
            int choice = SystemInUtils.getChar();
            switch (choice){
                case 's':
                    tree234.display();
                    break;
                case 'i':
                    System.out.println("Enter value to insert:");
                    value = SystemInUtils.getInt();
                    tree234.insert(value);
                    break;
                case 'f':
                    System.out.println("Enter value to find:");
                    value = SystemInUtils.getInt();
                    int found = tree234.find(value);
                    if(found!=-1){
                        System.out.println("Found:"+value);
                    }else {
                        System.out.println("not found:"+value);
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
