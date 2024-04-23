package org.biponline.ListInt;

import org.biponline.interfacce.IntegerList;

import java.util.Arrays;

public class MyIntegerArrayISKList implements IntegerList {
    public Integer[] array;
    private int size;

    public MyIntegerArrayISKList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Емкость должна быть больше 0.");
        }
        this.array = new Integer[capacity];

        this.size = 0;
    }
    @Override
    public Integer add(Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть нулевым");
        }
        if (size == array.length) {
            grow();
        }
        array[size] = item;
        size++;
        return item;
    }
    @Override
    public Integer add(int index, Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть нулевым");
        }
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы");
        }
        if (size == array.length) {
            grow();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
        return item;
    }
    @Override
    public Integer set(int index, Integer item) {
        if (item == null) {
            throw new IllegalArgumentException("Элемент не может быть нулевым");
        }
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы");
        }
        Integer replacedItem = array[index];
        array[index] = item;
        return replacedItem;
    }
    @Override
    public Integer remove(Integer item) {
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
    public Integer remove(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы");
        }
        Integer removedItem = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        array[size - 1] = null;
        size--;
        return removedItem;
    }
    @Override
    public boolean contains(Integer item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return true;
            }
        }
        return false;

    }
    @Override
    public int indexOf(Integer item) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public int lastIndexOf(Integer item) {
        for (int i = size - 1; i >= 0; i--) {
            if (array[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }
    @Override
    public Integer get(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException("Индекс выходит за пределы");
        }
        return array[index];
    }
    @Override
    public boolean equals(IntegerList otherList) {
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
        Arrays.fill(array, null);
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        Integer[] newArray = new Integer[size];
        System.arraycopy(array, 0, newArray, 0, size);
        return newArray;
    }

    @Override
    public int lastIndex(int i) {
        return -1;
    }

    private void grow() {
        int newCapacity = (int) (array.length * 1.5);
        array = Arrays.copyOf(array, newCapacity);

    }
    private void swapElements(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);
        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;
                swapElements(arr, i, j);
            }
        }
        swapElements(arr, i + 1, end);
        return i + 1;
    }
    public void quickSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);
            quickSort(arr, begin, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, end);
        }
    }
    public boolean contains(int[] arr, int element) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (element == arr[mid]) {
                return true;
            }
            if (element < arr[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}