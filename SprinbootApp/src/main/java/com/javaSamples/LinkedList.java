package com.javaSamples;

import sun.awt.image.ImageWatched;

public class LinkedList {
    Node head; //list will have atleast one node.
    int size = 0;
    static class Node {
        private int data;
        private Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private static void printList(LinkedList list){
        Node n = list.head;
        System.out.print("[");
        while(n != null){
            System.out.print(""+n.data+" ");
            n=n.next;
        }
        System.out.println("]");
    }

    private static void addInFront(LinkedList list, Node node) {
        System.out.println("Adding in the front");
        node.next = list.head;
        list.head = node;
        printList(list);
    }

    private static void addInLast(LinkedList list, Node node) {
        System.out.println("Adding in the last");
        if(list.head == null){
            //Node first = new Node(01);
            list.head = node;
            printList(list);
            return;
        }
        Node curr = list.head;
        while (curr.next !=null) {
            curr = curr.next;
        }
        if(curr.next == null) {
            curr.next = node;
            node.next = null;
        }
        printList(list);
    }

    private static void addAtIndex(LinkedList list, Node after, Node node){
        System.out.println("Adding in the given position");
        if(after == null){
            System.out.println("After node cannot be null");
            return;
        }
        node.next = after.next;
        after.next = node;
        printList(list);
    }

    private static void deleteFromList(LinkedList list, int data){
        System.out.println("Deleting a give node");
        Node curr = list.head, prev=null;

        if(curr !=null && curr.data == data) {
            list.head = curr.next;
            printList(list);
            return;
        }
        while(curr != null && curr.data !=data){
            prev = curr;
            curr = curr.next;
        }
        if(curr.data == data){
            prev.next = curr.next;
            curr.next = null;
        }
        printList(list);
    }

    private static void deleteAtPosition(LinkedList list, int position){
        System.out.println("Deleting at a given position");
        Node curr = list.head, prev=null;

        if (curr == null){
            return ;
        }

        if(position == 0) {
            curr = curr.next;
            printList(list);
            return;
        }

        for(int i=0; curr!=null && i<position;i++){
            curr = curr.next;
        }

        Node next = curr.next.next;
        curr.next = next;
    }

    public static void main(String[] args){
        LinkedList list = new LinkedList();
        list.head = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);

        list.head.next = n2;
        n2.next = n3;

        // printList(list);
        addInFront(list, new Node(4));
        addInLast(list, new Node(5));
        addAtIndex(list, list.head.next.next, new Node(6));

        deleteFromList(list, 1);
        deleteAtPosition(list, 3);
    }
}
