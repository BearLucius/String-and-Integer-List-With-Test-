import org.biponline.ListInt.MyIntegerArrayISKList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Тест Integer List'а")
class MyIntegerArrayListTest {
        private MyIntegerArrayISKList list;

    @BeforeEach
    public void setUp() {
        list = new MyIntegerArrayISKList(9);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
    }
    @Test
    @DisplayName("Добавление в массив элемента без индекса")
    public void addElementWithoutIndexInArray() {
        assertEquals(1, list.add(1));

        assertThrows(IllegalArgumentException.class, () -> list.add(null));
    }

    @Test
    @DisplayName("Добавление в массив элемента с индексом")
    public void addElementWithIndexInArray() {
        assertEquals(1, list.add(0, 1));
        assertThrows(IllegalArgumentException.class, () -> list.add(0, null));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.add(-999, 999));
    }

    @Test
    @DisplayName("Получение элемента в массиве по его индексу")
    public void getElementInArrayByIndex() {
        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);
        assertEquals(3, list.get(2));
        // Исключение на получение элемента с индексом -555
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.get(-555));
    }

    @Test
    @DisplayName("Добавление элемента в массив на место уже существующего")
    public void setElementReplacingInitialElement() {
        assertEquals(2, list.set(1, 2));
        assertThrows(IllegalArgumentException.class, () -> list.set(3, null));
    }

    @Test
    @DisplayName("Удаление из массива элемента без индекса")
    public void removeElementWithoutIndexFromArray() {
        list.add(0);

        assertEquals(list.get(0), list.remove(0));
        assertThrows(IllegalArgumentException.class, () -> list.remove(null));
    }

    @Test
    @DisplayName("Удаление из массива элемента с индексом")
    public void removeElementWithIndexFromArray() {
        list.add(0);
        assertEquals(1, list.remove(0));
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> list.remove(-1));
    }

    @Test
    @DisplayName("Поиск элемента в массиве с его начала")
    public void indexOf() {
        assertEquals(list.indexOf(2), 1);
        assertEquals(4, list.indexOf(5));
    }
    @Test
    @DisplayName("Поиск элемента в массиве с его конца")
    public void lastIndexOf() {
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(12, list.lastIndexOf(3));
        assertEquals(-1, list.lastIndexOf(0));
    }

    @Test
    @DisplayName("Проверка на равенство двух массивов по размеру")
    public void isEquals() {
        MyIntegerArrayISKList list = new MyIntegerArrayISKList(3);
        MyIntegerArrayISKList list2 = new MyIntegerArrayISKList(3);

        list.add(0, 1);
        list.add(1, 2);
        list.add(2, 3);

        list2.add(0, 4);
        list2.add(1, 5);
        list2.add(1, 5);

        assertTrue(list.equals(list)); // Проверка на равенство двух списков
        assertThrows(IllegalArgumentException.class, () -> list.equals(null)); // Исключение на пустой сравниваемый список
    }

    @Test
    @DisplayName("Проверка на неравенство двух массивов по размеру")
    public void notEquals() {
        MyIntegerArrayISKList list2 = new MyIntegerArrayISKList(3);
        list.add(1);
        list2.add(5);
        list2.add(2);
        assertFalse(list.equals(list2)); // Проверка на неравенство двух списков
    }

    @Test
    @DisplayName("Проверка на существование элемента в массиве")
    public void contains() {
        list.add(0, 0);

//        assertEquals(list.get(0), list.contains(0[], 0));
    }

    @Test
    @DisplayName("Проверка на несуществование элемента в массиве")
    public void notContains() {
        assertFalse(list.contains(0));
    }

    @Test
    @DisplayName("Быстрая сортировка")
    public void quickSortTest(){
    }

    @Test
    @DisplayName("Получить фактический размер массива")
    public void size() {
        list.add(1);
        assertEquals(11, list.size());
    }

    @Test
    @DisplayName("Проверка очищения массива.")
    public void clear() {
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("Проверка создания нового массива.")
    public void toArray() {
        list.toArray();
        assertEquals(list.size(), 10);
    }

    @Test
    @DisplayName("Проверка на увеличение места при заполнении")
    public void grow() {
        list.add(0);
    }
}
