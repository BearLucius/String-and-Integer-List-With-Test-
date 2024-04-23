package org.biponline.ListString;

import java.util.Arrays;
public class MainStringList {

    public static void main(String[] args) {
        MyStringIKSLArrayList list = new MyStringIKSLArrayList(5);
        // Testing add(Integer item) method

        list.add("Ы-ы-е");
        list.add("Ква");
        list.add("Кря");

        System.out.println("List after adding elements: " + Arrays.toString(list.array));
        // Testing add(int index, Integer item) method

        list.add(1, "Мяу-мяу");
        System.out.println("List after adding element at index 1: " + Arrays.toString(list.array));
        // Testing set(int index, Integer item) method

        list.set(2, "Мяу");
        System.out.println("List after setting element at index 2: " + Arrays.toString(list.array));
        // Testing remove(Integer item) method

        list.remove(0); // Delete 10 (Cause if u don't do this, program just give you error) and type 0 for stabling work
        System.out.println("List after removing element 10: " + Arrays.toString(list.array));
        // Testing remove(int index) method

        list.remove(0);
        System.out.println("List after removing element at index 0: " + Arrays.toString(list.array));
        // Testing contains(Integer item) method

        String item = "Мяу";
        System.out.println("List contains element Мяу: " + list.contains(String.valueOf(item)));
    }
}