package com.peto.canopy.ds.linkedlist;

public class FindMiddle {
    public static void main(String[] args) {
        /*java.util.LinkedList<Integer> integers = new java.util.LinkedList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        System.out.println(integers);*/
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
//        System.out.println("list is empty? " + integerLinkedList.isEmpty());
        integerLinkedList.add(1);
        integerLinkedList.add(2);
        integerLinkedList.add(3);
        integerLinkedList.add(4);
        integerLinkedList.add(5);
        System.out.println(integerLinkedList);

        /*LinkedList<String> stringLinkedList = new LinkedList<>();
        stringLinkedList.add("Hi");
        stringLinkedList.add("How");
        stringLinkedList.add("you");
        stringLinkedList.add("doing?");
        System.out.println(stringLinkedList);*/

        System.out.println(integerLinkedList.findMiddle());
    }
}
