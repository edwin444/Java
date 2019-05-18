package com.tutorials.iteratorIterable;

/*
Note: method return types can be of type interface, but we cannot instantiate and object new interfaceName()
 */

import java.util.Iterator;

class Node<Type>{
    Type data;
    Node<Type> next;

    public Type getData(){
        return this.data;
    }
}
//this class provides a linked list implementation,
//also returns an iterator object to traverse through the linked list object
//also contains utility functions for returning head and tail of the given linked list
class CustomLinkedList<Type> implements Iterable<Type>{

    Node<Type> head,tail;
    //to return the iterator instance from linked list object.
    public Iterator<Type> iterator()
    {
        return new CustomLinkedListIterator<Type>(this);
    }

    //to return head
    public Node<Type> getHead(){
        return this.head;
    }
    //to return tail
    public Node<Type> getTail(){
        return this.tail;
    }
    //to add a node to the start of a linked list always
    public void add(Type data)
    {
        Node<Type> newNode = new Node<Type>();
        newNode.data = data;
        newNode.next = null;
        if (this.head == null)
        {
            this.head = newNode;
            this.tail = newNode;
        }
        else
        {
            newNode.next = this.head.next;
            this.head.next = newNode;
        }
    }
}
//this class used to provide custom implementation of the Iterator interface
//it has hasNext() and next() used with reference to the iterator object for the custom linked list.
class CustomLinkedListIterator<Type> implements Iterator<Type>{
    Node<Type> current;
    public CustomLinkedListIterator(CustomLinkedList<Type> list){
        current = list.head;
    }
    public boolean hasNext(){
        return current != null;
    }
    public Type next(){
        Type temp = current.getData();
        current = current.next; //next Node<Type> object
        return temp;
    }
}
public class Main {
    public static void main(String[] args)
    {
        CustomLinkedList<Integer> ll = new CustomLinkedList<Integer>();
        ll.add(10);
        ll.add(20);
        ll.add(90);
        ll.add(80);

        Iterator<Integer> it = ll.iterator();
        //as when next() method is called iterator automatically increments in our implementation.
        while (it.hasNext()!=false)
        {
            System.out.println(it.next());
        }
    }
}
