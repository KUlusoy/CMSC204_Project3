import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.ListIterator;

public class GenericLinkedListStudentTest {

    private GenericLinkedList<String> list;

    @Before
    public void setUp() {
        list = new GenericLinkedList<>();
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        list.addFirst("A");
        assertFalse(list.isEmpty());
    }

    @Test
    public void testSize() {
        assertEquals(0, (int) list.size());
        list.addLast("A");
        list.addLast("B");
        assertEquals(2, (int) list.size());
    }

    @Test
    public void testGetFirst() {
        list.addFirst("A");
        list.addFirst("B");
        assertEquals("B", list.getFirst());
    }

    @Test
    public void testGetLast() {
        list.addLast("A");
        list.addLast("B");
        assertEquals("B", list.getLast());
    }

    @Test
    public void testRemoveFirst() {
        list.addLast("A");
        list.addLast("B");
        assertEquals("A", list.removeFirst());
        assertEquals(1, (int) list.size());
    }

    @Test
    public void testRemoveLast() {
        list.addLast("A");
        list.addLast("B");
        assertEquals("B", list.removeLast());
        assertEquals(1, (int) list.size());
    }

    @Test
    public void testRemoveByIndex() {
        list.addLast("A");
        list.addLast("B");
        list.addLast("C");
        list.remove(1);
        assertEquals(2, (int) list.size());
    }

    @Test
    public void testRemoveByElement() {
        list.addLast("A");
        list.addLast("B");
        assertTrue(list.remove("A"));
        assertFalse(list.contains("A"));
    }

    @Test
    public void testToArray() {
        list.addLast("A");
        list.addLast("B");
        Object[] array = list.toArray();
        assertEquals("A", array[0]);
        assertEquals("B", array[1]);
    }

    @Test
    public void testIteratorPrevious() {
        list.addLast("A");
        list.addLast("B");
        ListIterator<String> it = list.iterator();
        it.next();
        it.next();
        assertEquals("B", it.previous());
    }
}