package com.peto.canopy.ds.linkedlist;

public class FlattenLinkedList {
    public static void main(String[] args) {
        // linked list of linked lists
        LinkedList<LinkedList<Integer>> list = new LinkedList<>();
        list.add(new LinkedList<>(5, 7, 8, 30));
        list.add(new LinkedList<>(10, 20));
        list.add(new LinkedList<>(19, 22, 50));
        list.add(new LinkedList<>(28, 35, 40, 45));
//        list.add(new LinkedList<>(28, 35, 40, 45, 7, null, 89));
        LinkedList<Integer> flatList = list.get(list.size - 1);
        for (int i = 0; i < list.size; i++) {
//            flatList = flatList.mergeTo(list.get(i));
        }
        System.out.println(flatList);
    }
}
