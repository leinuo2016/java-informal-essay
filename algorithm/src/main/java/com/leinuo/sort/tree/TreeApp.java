package com.leinuo.sort.tree;

import com.leinuo.sort.SystemInUtils;

import java.io.IOException;
import java.util.Objects;

/**
 * Create by leinuo on 2020/2/28 下午3:19
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class TreeApp {
    public static void main(String[] args) throws IOException {
        int value;
        Tree tree = new Tree();
        tree.insert(50,1.5);
        tree.insert(25,1.5);
        tree.insert(75,1.5);
        tree.insert(12,1.5);
        tree.insert(37,1.5);
        tree.insert(43,1.5);
        tree.insert(30,1.5);
        tree.insert(33,1.5);
        tree.insert(87,1.5);
        tree.insert(93,1.5);
        tree.insert(97,1.5);
        while (true){
            System.out.printf("Enter first letter of show,insert,find,delete,or traverse:");
            int choice = SystemInUtils.getChar();
            switch (choice){
                case 's':
                    tree.display();
                    break;
                case 'i':
                    System.out.println("Enter value to insert:");
                    value = SystemInUtils.getInt();
                    tree.insert(value,value+0.9);
                    break;
                case 'f':
                    System.out.println("Enter value to find:");
                    value = SystemInUtils.getInt();
                   Node found = tree.find(value);
                   if(Objects.nonNull(found)){
                       System.out.println("Found:");
                       found.displayNode();
                   }else {
                       System.out.println("not found:"+value);
                   }
                    break;
                case 'd':
                    System.out.println("Enter value to delete:");
                    value = SystemInUtils.getInt();
                    boolean isDelete = tree.delete(value);
                    if(isDelete){
                        System.out.println("delete:"+value);
                    }else {
                        System.out.println("not deltet:"+value);
                    }
                    break;
                case 't':
                    System.out.println("Enter type 1,2,3:");
                    value = SystemInUtils.getInt();
                    tree.traverse(value);
                    break;
                case 'e':
                    System.exit(0);
                default:
                    System.out.println("no case");
            }
        }
    }
}
