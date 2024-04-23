import org.biponline.ListInt.MyIntegerArrayISKList;
import org.biponline.ListString.MyStringIKSLArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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
    public void add()  {
        assertEquals( list.add(1),1);
        // assertEquals( list.add(null),null);
    }
    @Test
    public void remove()  {
        assertEquals(Integer.valueOf(2), list.remove(1));
        assertEquals(9, list.size());
        assertFalse(list.contains(2));
        // assertEquals(Integer.valueOf(2), list.remove(40));
        // assertEquals(Integer.valueOf(2), list.remove(null));
    }
    @Test
    public void indexOf()  {
        assertEquals(1, list.indexOf(2));
        assertEquals(3, list.indexOf(4));
    }
    @Test
    public void set() {
        assertEquals(Integer.valueOf(2), list.set(1,5));
        assertEquals(Integer.valueOf(5), list.get(1));
    }
    @Test
    public void testEquals() {
        assertTrue(list.equals(list));
    }
    @Test
    public void contains() {
        assertTrue(list.contains(2));
        assertFalse(list.contains(11));
    }
    @Test
    public void size() {
        assertEquals(10, list.size());
    }
    @Test
    public void clear()  {
        list.clear();
        assertTrue(list.isEmpty());
    }
    @Test
    public void testik() {
        assertEquals(list.add(0),0);
        assertNotNull(0);
    }

}
