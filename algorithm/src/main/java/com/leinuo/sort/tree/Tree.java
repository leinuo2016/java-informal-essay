package com.leinuo.sort.tree;

import java.util.Objects;
import java.util.Stack;

/**
 * Create by leinuo on 2020/2/28 上午11:06
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class Tree {
    private Node root;
    public Tree(){
        root=null;
    }

    public Node find(int key){
        Node current = root;
        while (current.iData!=key){
            current = key<current.iData?current.leftNode:current.rightNode;
            if(Objects.isNull(current)){
                return null;
            }
        }
        return current;
    }

    public void insert(int id,double dd){
        Node newNode = new Node();
        newNode.iData = id;
        newNode.dData = dd;
        if(Objects.isNull(root)){
            root = newNode;
        }else {
            Node current = root;
            Node  parent;
            while (true){
                parent = current;
                if(id<current.iData){
                    current = current.leftNode;
                    if(Objects.isNull(current)){
                        parent.leftNode = newNode;
                        return;
                    }
                }else {
                    current = current.rightNode;
                    if(Objects.isNull(current)){
                        parent.rightNode = newNode;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftNode = true;
        while (current.iData != key){
            parent = current;
            if(key<current.iData){
                isLeftNode = true;
                current = current.leftNode;
            }else {
                isLeftNode = false;
                current = current.rightNode;
            }
            if(Objects.isNull(current)){
                return false;
            }
        }
        //如果当前节点为根节点或叶子节点
        if(Objects.isNull(current.leftNode)&&Objects.isNull(current.rightNode)){
            if(current==root){
                root=null;
            }else if(isLeftNode){
                parent.leftNode=null;
            }else {
                parent.rightNode=null;
            }
            //如果当前节点为没有右子节点的节点
        }else if(Objects.isNull(current.rightNode)){
            if(current==root){
                root = current.leftNode;
            }else if(isLeftNode){
                parent.leftNode = current.leftNode;
            }else {
                parent.rightNode = current.leftNode;
            }
            //如果当前节点为没有左子节点的节点
        }else if(Objects.isNull(current.leftNode)){
            if(current==root){
                root = current.rightNode;
            }else if(isLeftNode){
                parent.leftNode = current.rightNode;
            }else {
                parent.rightNode = current.rightNode;
            }
        }else {
            Node successor = getSuccessor(current);
            if(Objects.isNull(current)){
                root = successor;
            }else if(isLeftNode){
                parent.leftNode = successor;
            }else {
                parent.rightNode = successor;
            }
            successor.leftNode = current.leftNode;
        }
        return true;
    }

    private Node getSuccessor(Node delNode) {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightNode;
        while (!Objects.isNull(current)){
            successorParent = successor;
            successor = current;
            current = current.leftNode;
        }
        if(successor!=delNode.rightNode){
            successorParent.leftNode = successor.rightNode;
            successor.rightNode = delNode.rightNode;
        }
        return successor;
    }

    public void traverse(int type){
        switch (type){
            case 1:
                System.out.print("\nPreOrder traversal:");
                preOrder(root);
                break;
            case 2:
                System.out.print("\nInOrder traversal:");
                inOrder(root);
                break;
            case 3:
                System.out.print("\nPostOrder traversal:");
                postOrder(root);
                break;
        }
    }

    private void postOrder(Node localNode) {
        if(Objects.nonNull(localNode)){
            postOrder(localNode.leftNode);
            postOrder(localNode.rightNode);
            System.out.print(localNode.iData+" ");
        }
    }

    private void inOrder(Node localNode) {
        if(Objects.nonNull(localNode)){
            inOrder(localNode.leftNode);
            System.out.print(localNode.iData+" ");
            inOrder(localNode.rightNode);
        }
    }

    private void preOrder(Node localNode){
        if(Objects.nonNull(localNode)){
            System.out.print(localNode.iData+" ");
            preOrder(localNode.leftNode);
            preOrder(localNode.rightNode);
        }
    }

    public void display(){
        Stack stack = new Stack();
        stack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println("..........................................");
        while (isRowEmpty==false){
            Stack localStack = new Stack();
            isRowEmpty=true;
            for (int j = 0; j < nBlanks ; j++)
                System.out.print(' ');
            while (!stack.isEmpty()){
                Node temp = (Node) stack.pop();
                if(Objects.nonNull(temp)){
                    System.out.print(temp.iData);
                    localStack.push(temp.leftNode);
                    localStack.push(temp.rightNode);
                    if(Objects.nonNull(temp.leftNode)||Objects.nonNull(temp.rightNode)){
                        isRowEmpty = false;
                    }else {
                        System.out.print("--");
                        localStack.push(null);
                        localStack.push(null);
                    }
                    for (int j = 0; j < nBlanks*2-2; j++)
                        System.out.print(' ');
                }
                System.out.println();
                nBlanks /=2;
                while (!localStack.isEmpty())
                    stack.push(localStack.pop());
            }
        }
        System.out.println("..........................................");
    }

}
