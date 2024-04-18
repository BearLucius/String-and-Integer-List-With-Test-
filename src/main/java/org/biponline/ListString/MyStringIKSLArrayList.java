package org.biponline.ListString;

import org.biponline.interfacce.StringList;

public class MyStringIKSLArrayList implements StringList {
    private String[] array;
    private int size;
    public MyStringIKSLArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Емкость должна быть больше 0.");
        }
        this.array = new String[capacity];
        this.size = 0;
    }
    @Override
    public String add(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть нулевым");
        }
        if (size == array.length) {
            throw new ArrayIndexOutOfBoundsException("Массив заполнен, невозможно добавить больше элементов");
        }
        array[size] = item;
        size++;
        return item;
    }
    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть нулевым");
        }
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы");
        }
        if (size == array.length) {
            throw new ArrayIndexOutOfBoundsException("Массив заполнен, невозможно добавить больше элементов");
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
        return item;
    }
    @Override
    public String set(int index, String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть нулевым");
        }
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы");
        }
        String replacedItem = array[index];
        array[index] = item;
        return replacedItem;
    }
    @Override
    public String remove(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть нулевым");
        }
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                for (int j = i; j < size - 1; j++) {
                    array[j] = array[j + 1];
                }
                array[size - 1] = null;
                size--;
                return item;
            }
        }
        throw new IllegalArgumentException("Элемент не найден в списке");
    }
    @Override
    public String remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы");
        }
        String removedItem = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return removedItem;
    }
    @Override
    public boolean contains(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public String get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы");
        }
        return array[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new IllegalArgumentException("Другой cписок не может быть нулевым");
        }
        if (this.size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!array[i].equals(otherList.get(i))) {
                return false;
            }
        }
        return true;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }
    @Override
    public String[] toArray() {
        String[] newArray = new String[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }
}