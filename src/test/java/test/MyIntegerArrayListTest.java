package test;

import org.biponline.ListInt.MyIntegerArrayISKList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MyIntegerArrayListTest {
        private MyIntegerArrayISKList list;
    @Test
    public void add()  {
        MyIntegerArrayISKList list = new MyIntegerArrayISKList(5);
        assertEquals( list.add(1),1);
    }
    @Test
    public void remove()  {
        MyIntegerArrayISKList list = new MyIntegerArrayISKList(5);
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(Integer.valueOf(2), list.remove(1));
        assertEquals(2, list.size());
        assertFalse(list.contains(2));
    }
    @Test
    public void indexOf()  {
        MyIntegerArrayISKList list = new MyIntegerArrayISKList(5);
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(1, list.indexOf(2));
        assertEquals(-1, list.indexOf(4));
    }
    @Test
    public void set() {
        MyIntegerArrayISKList list = new MyIntegerArrayISKList(3);
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(Integer.valueOf(2), list.set(1, 5));
        assertEquals(Integer.valueOf(5), list.get(1));
    }

    @Test
    public  void testEquals() {
        MyIntegerArrayISKList list = new MyIntegerArrayISKList(5);
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.equals(list));
    }

    @Test
    public  void contains() {
        MyIntegerArrayISKList list = new MyIntegerArrayISKList(5);
        list.add(1);
        list.add(2);
        list.add(3);

        assertTrue(list.contains(2));
        assertFalse(list.contains(4));
    }

    @Test
    public void size() {
        MyIntegerArrayISKList list = new MyIntegerArrayISKList(5);
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(3, list.size());
    }


    @Test
    public  void clear()  {
        MyIntegerArrayISKList list = new MyIntegerArrayISKList(5);
        list.add(1);
        list.add(2);
        list.add(3);
        list.clear();

        assertTrue(list.isEmpty());
    }
}
