package org.biponline.ListInt;

import java.util.Arrays;
public class MainIntList {

    public static void main(String[] args) {
        MyIntegerArrayISKList list = new MyIntegerArrayISKList(3);
        // Testing add(Integer item) method

        list.add(1);
        list.add(2);
        list.add(3);

        System.out.println("List after adding elements: " + Arrays.toString(list.array));
        // Testing add(int index, Integer item) method

        list.add(1, 10);
        System.out.println("List after adding element at index 1: " + Arrays.toString(list.array));
        // Testing set(int index, Integer item) method

        list.set(2, 20);
        System.out.println("List after setting element at index 2: " + Arrays.toString(list.array));
        // Testing remove(Integer item) method

        list.remove(0); // Delete 10 and type 0 for stabling work
        System.out.println("List after removing element 10: " + Arrays.toString(list.array));
        // Testing remove(int index) method

        list.remove(0);
        System.out.println("List after removing element at index 0: " + Arrays.toString(list.array));
        // Testing contains(Integer item) method

        Integer item = 20;
        System.out.println("List contains element 20: " + list.contains(item));
    }
}