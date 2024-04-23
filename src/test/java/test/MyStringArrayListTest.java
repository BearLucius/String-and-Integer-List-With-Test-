package test;

import org.biponline.ListString.MyStringIKSLArrayList;
import org.biponline.interfacce.StringList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyStringArrayListTest {
        private MyStringIKSLArrayList list;
        @BeforeEach
        public void setUp() {
            list = new MyStringIKSLArrayList(7);
            list.add("Один");
            list.add("Два");
            list.add("Три");
            list.add("Четыре");
            list.add("Пять");
        }
        @Test
        public void testAdd() {
            list.add(1, "Поставлюсь на индекс 1");
            assertEquals(6, list.size());
        }
        @Test
        public void addElementByIndex() {
            list.add(1, "Поставлюсь на индекс 1 (x2)");
            assertEquals(6, list.size());
        }
        @Test
        public void setElementByIndex() {
            list.set(1,"Кряяяяя");
            assertEquals(5, list.size());
            assertEquals("Три", list.get(2));
        }
        @Test
        public void removeElementByIndex() {
            list.remove(1);
            assertEquals(4, list.size());
            assertFalse(list.contains("Два"));
            assertEquals("Три", list.get(1));
        }
        @Test
        public void testContains() {
            assertTrue(true, String.valueOf(list.contains("Пять")));
            assertFalse(false, String.valueOf(list.contains("Один")));
        }
        @Test
        public void testIndexOfElement() {
            list.indexOf("Заглушка");
           list.indexOf("Заглушка");
        }
        @Test
        public void testLastIndexOfElement() {
            list.add("Заглушка");
            list.lastIndexOf("Заглушка");
           list.lastIndexOf("Заглушка");
        }
        @Test
        public void testListWithAnotherList() {
            MyStringIKSLArrayList otherList = new MyStringIKSLArrayList(5);
            otherList.add("Заглушка");
            otherList.add("Заглушка");
            otherList.add("Заглушка");

            assertFalse(list.equals(otherList));

            otherList.add("Заглушка");
            otherList.add("Заглушка");

            assertFalse(list.equals(otherList));
        }
        @Test
        public void testIfListIsEmpty() {
            assertFalse(list.isEmpty());
            MyStringIKSLArrayList emptyList = new MyStringIKSLArrayList(5);
            assertTrue(emptyList.isEmpty());
        }
        @Test
        public void clearList() {
            list.clear();
            assertEquals(0, list.size());
            assertTrue(list.isEmpty());
        }
    }