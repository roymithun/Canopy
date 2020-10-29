package com.peto.canopy.ds.linkedlist;

import io.reactivex.rxjava3.annotations.NonNull;

public class LinkedList<T> {
    Node<T> start;
    int size = 0;

    public LinkedList() {
    }

    public LinkedList(@NonNull T... values) {
        for (T v : values) {
            add(v);
        }
    }

    void add(@NonNull T value) {
        addLast(value);
    }

    void addFirst(@NonNull T value) {
        /*if (value == null) {
            throw new UnsupportedOperationException();
        }*/
        Node<T> node = new Node<>();
        node.value = value;
        node.next = null;

        if (isEmpty()) {
            start = node;
        } else {
            Node<T> temp = start;
            while (temp.next != null) {
                System.out.println(temp.value);
                temp = temp.next;
            }
            temp.next = node;
        }
        size++;
    }

    void addLast(@NonNull T value) {
        /*if (value == null) {
            throw new UnsupportedOperationException();
        }*/
        Node<T> node = new Node<>();
        node.next = start;
        node.value = value;
        start = node;
        size++;
    }

    T findMiddle() {
        if (isEmpty()) {
            return null;
        }
        Node<T> slow = start;
        Node<T> fast = start;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.value;
    }

    T get(int idx) {
        if (isEmpty() || idx >= size) {
            throw new IndexOutOfBoundsException();
        }
        int currentIdx = 0;
        Node<T> temp = start;
        while (temp != null && currentIdx <= idx) {
            if (currentIdx == idx) {
                return temp.value;
            }
            temp = temp.next;
            currentIdx++;
        }
        throw new IllegalStateException();
    }

    boolean isEmpty() {
        return start == null;
    }

    int size() {
        return size;
        /*int size = 0;
        Node<T> temp = start;
        while (temp != null) {
            size++;
            temp = temp.next;
        }
        return size;*/
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        String[] result = new String[size];
        Node<T> temp = start;
        int i = 0;
        while (temp != null) {
            result[i++] = temp.value == null ? null : temp.value.toString();
            temp = temp.next;
        }

        for (int p = 0, q = size - 1; p <= size / 2 && q >= size / 2; p++, q--) {
            swap(result, p, q);
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (String s : result) {
            sb.append(s);
            sb.append(", ");
        }
        int x = sb.lastIndexOf(", ");
        return sb.substring(0, x) + "]";
    }

    private void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /*public LinkedList<Integer> mergeTo(LinkedList<Integer> b) {
        if (isEmpty()) {
            return b;
        }
        Node<Integer> tempA = (Node<Integer>) start;
        Node<Integer> tempB = b.start;
        LinkedList<Integer> result = new LinkedList<>();
        while (tempA != null && tempB != null) {
            if (tempA.value < tempB.value) {
                result.add(tempA.value);
                tempA = tempA.next;
                if (tempA == null) {
                    while (tempB != null) {
                        result.add(tempB.value);
                        tempB = tempB.next;
                    }
                }
            } else if (tempA.value > tempB.value) {
                result.add(tempB.value);
                tempB = tempB.next;
                if (tempB == null) {
                    while (tempA != null) {
                        result.add(tempA.value);
                        tempA = tempA.next;
                    }
                }
            } else {
                result.add(tempA.value);
                result.add(tempB.value);
                tempA = tempA.next;
                tempB = tempB.next;
                if (tempA == null) {
                    while (tempB != null) {
                        result.add(tempB.value);
                        tempB = tempB.next;
                    }
                }
                if (tempB == null) {
                    while (tempA != null) {
                        result.add(tempA.value);
                        tempA = tempA.next;
                    }
                }
            }
        }
        return result;
    }*/
}
