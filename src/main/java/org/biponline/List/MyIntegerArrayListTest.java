package org.biponline.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyIntegerArrayListTest {
        private MyIntegerArrayList list;
        @BeforeEach
        public void setUp() {
            list = new MyIntegerArrayList(7);
            list.add(1);
            list.add(2);
            list.add(3);
            list.add(4);
            list.add(5);
        }
        @Test
        public void testAdd() {
            list.add(1, 7);
            assertEquals(6, list.size());
        }
        @Test
        public void addElementByIndex() {
            list.add(1, 2);
            assertEquals(6, list.size());
        }
        @Test
        public void setElementByIndex() {
            list.set(1,5);
            assertEquals(5, list.size());
            assertEquals(5, list.get(1));
        }
        @Test
        public void removeElementByIndex() {
            list.remove(1);
            assertEquals(4, list.size());
            assertFalse(list.contains(2));
            assertEquals(1, list.get(0));
        }
        @Test
        public void testContains() {
            assertTrue(list.contains(2));
            assertFalse(list.contains(7));
        }
        @Test
        public void testIndexOfElement() {
            assertEquals(1, list.indexOf(2));
            assertEquals(-1, list.indexOf(7));
        }
        @Test
        public void testLastIndexOfElement() {
            list.add(1);
            assertEquals(2, list.lastIndexOf(3));
            assertEquals(-1, list.lastIndexOf(7));
        }
        @Test
        public void testListWithAnotherList() {
            MyIntegerArrayList otherList = new MyIntegerArrayList(5);
            otherList.add(3);
            otherList.add(5);
            otherList.add(6);

            assertFalse(list.equals(otherList));

            otherList.add(7);
            otherList.add(8);

            assertFalse(list.equals(otherList));
        }

        @Test
        public void testIfListIsEmpty() {
            assertFalse(list.isEmpty());
            MyIntegerArrayList emptyList = new MyIntegerArrayList(5);
            assertTrue(emptyList.isEmpty());
        }
        @Test
        public void clearList() {
            list.clear();
            assertEquals(0, list.size());
            assertTrue(list.isEmpty());
        }
    }