package com.leinuo.sort.link;

import java.util.Objects;

/**
 * Create by leinuo on 2020/2/17 下午4:42
 * <p>
 * qq:1321404703 https://github.com/leinuo2016
 */
public class LinkList {
    private Link first;

    public LinkList() {
        this.first = null;
    }

    public boolean isEmpty(){
        return Objects.isNull(first);
    }

    public void insertFirst(int id,double dd){
        Link link = new Link(id,dd);
        link.next = first;
        first = link;
    }

    public Link deleteFirst(){
        Link link = first;
        if(isEmpty()){
            return null;
        }
         first= first.next;
        return link;
    }

    public void displayList(){
        Link currentLink = first;
        while (Objects.nonNull(currentLink)){
            currentLink.display();
            currentLink = currentLink.next;
        }
    }

    public Link find(int a){
        Link currentLink = first;
        while (currentLink.aInt!=a){
            if(Objects.isNull(currentLink)){
                return null;
            }else {
                currentLink = currentLink.next;
            }
        }
        return currentLink;
    }

    public Link delete(int a){
        Link currentLink = first;
        Link temp = first;
        while (currentLink.aInt!=a){
            if(Objects.isNull(currentLink)){
                return null;
            }else {
                temp = currentLink;
                currentLink = currentLink.next;
            }
        }
        if(first == currentLink){
            first = first.next;
        }else {
            temp.next = currentLink.next;
        }
        return currentLink;
    }
}
