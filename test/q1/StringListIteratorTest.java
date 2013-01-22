package q1;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.*;

/**
 * User: Sam Wright
 * Date: 21/01/2013
 * Time: 18:08
 */
public class StringListIteratorTest {
    List<String> lst;
    ListIterator<String> itr;

    @Before
    public void setUp() throws Exception {
        lst = new LinkedList<String>(Arrays.asList(new String[]{"0","1","2"}));
        createIterator();
    }

    private void createIterator() {
        itr = new StringListIterator(lst);
//        itr = lst.listIterator();
    }

    @Test
    public void testHasNext() throws Exception {
        for (int i = 0; i < 3; ++i) {
            assertTrue(itr.hasNext());
            itr.next();
        }

        assertFalse(itr.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void testHasNoNext() throws Exception {
        testNext();
        itr.next();
    }

    @Test
    public void testNext() throws Exception {
        assertEquals("0", itr.next());
        assertEquals("1", itr.next());
        assertEquals("2", itr.next());
    }

    @Test
    public void testHasPrevious() throws Exception {
        assertFalse(itr.hasPrevious());

        testNext();
        for (int i = 0; i < 3; ++i) {
            assertTrue(itr.hasPrevious());
            itr.previous();
        }

        assertFalse(itr.hasPrevious());
    }

    @Test(expected = NoSuchElementException.class)
    public void testHasNoPrev() throws Exception {
        itr.previous();
    }

    @Test
    public void testPrevious() throws Exception {
        testNext();

        assertEquals("2", itr.previous());
        assertEquals("1", itr.previous());
        assertEquals("0", itr.previous());
    }

    @Test
    public void testNextIndex() throws Exception {
        for (int i = 0; i < 3; ++i) {
            assertEquals(i, itr.nextIndex());
            itr.next();
        }
    }

    @Test
    public void testPreviousIndex() throws Exception {
        testNext();

        for (int i = 2; i >= 0; --i) {
            assertEquals(i, itr.previousIndex());
            itr.previous();
        }
    }

    @Test(expected = IllegalStateException.class)
    public void testRemoveZerothElement() throws Exception {
        itr.remove();
    }

    @Test
    public void testRemoveFirstElementForwards() throws Exception {
        itr.next();
        itr.remove();
        assertEquals("1", itr.next());
        assertEquals("2", itr.next());
        assertFalse(itr.hasNext());

        assertEquals(listOf("1","2"), lst);
    }

    @Test
    public void testRemoveSecondElementForwards() throws Exception {
        itr.next();
        itr.next();
        itr.remove();
        assertEquals("2", itr.next());
        assertFalse(itr.hasNext());

        assertEquals(listOf("0", "2"), lst);
    }

    @Test
    public void testRemoveThirdElementForwards() throws Exception {
        testNext();

        itr.remove();
        assertFalse(itr.hasNext());

        assertEquals(listOf("0", "1"), lst);
    }

    @Test
    public void testRemoveFirstElementBackwards() throws Exception {
        testNext();

        itr.previous();
        itr.previous();
        itr.previous();
        itr.remove();

        assertFalse(itr.hasPrevious());

        assertEquals(listOf("1", "2"), lst);
    }

    @Test
    public void testRemoveSecondElementBackwards() throws Exception {
        testNext();

        itr.previous();
        itr.previous();

        itr.remove();

        assertEquals("0", itr.previous());
        assertFalse(itr.hasPrevious());

        assertEquals(listOf("0", "2"), lst);
    }

    @Test
    public void testRemoveAllElementsForwards() throws Exception {
        assertEquals("0", itr.next());
        itr.remove();
        assertEquals("1", itr.next());
        itr.remove();
        assertEquals("2", itr.next());
        itr.remove();
    }

    @Test
    public void testRemoveAllElementsForwardsThenAdd() throws Exception {
        testRemoveAllElementsForwards();
        itr.add("z");
        assertTrue(itr.hasPrevious());
        assertFalse(itr.hasNext());
        assertEquals("z", itr.previous());
    }

    @Test
    public void testRemoveAllElementsBackwards() throws Exception {
        testNext();
        assertEquals("2", itr.previous());
        itr.remove();
        assertEquals("1", itr.previous());
        itr.remove();
        assertEquals("0", itr.previous());
        itr.remove();
    }

    @Test
    public void testRemoveAllElementsBackwardsThenAdd() throws Exception {
        testRemoveAllElementsBackwards();
        itr.add("z");
        assertTrue(itr.hasPrevious());
        assertFalse(itr.hasNext());
        assertEquals("z", itr.previous());
    }

    @Test
    public void testSetForwards() throws Exception {
        for (char c = 'a'; c <= 'c'; ++c) {
            itr.next();
            itr.set(String.valueOf(c));
            assertTrue(itr.hasPrevious());
            assertEquals(String.valueOf(c), itr.previous());
            assertTrue(itr.hasNext());
            assertEquals(String.valueOf(c), itr.next());
        }

        assertFalse(itr.hasNext());
        assertEquals(listOf("a","b","c"), lst);
    }

    @Test
    public void testSetBackwards() throws Exception {
        testNext();

        for (char c = 'a'; c <= 'c'; ++c) {
            itr.previous();
            itr.set(String.valueOf(c));
            assertTrue(itr.hasNext());
            assertEquals(String.valueOf(c), itr.next());
            assertTrue(itr.hasPrevious());
            assertEquals(String.valueOf(c), itr.previous());
        }

        assertFalse(itr.hasPrevious());
        assertEquals(listOf("c", "b", "a"), lst);
    }

    @Test(expected = IllegalStateException.class)
    public void testSetZeroth() throws Exception {
        itr.set("a");
    }

    @Test
    public void testAddToEmpty() throws Exception {
        lst = new LinkedList<String>();
        createIterator();

        itr.add("a");
        assertTrue(itr.hasPrevious());
        assertFalse(itr.hasNext());
        assertEquals("a", itr.previous());

        assertEquals(listOf("a"), lst);
    }

    @Test
    public void testAddForwards() throws Exception {
        itr.add("a");
        assertEquals("0", itr.next());
        itr.add("b");
        assertEquals("1", itr.next());
        itr.add("c");
        assertEquals("2", itr.next());
        assertFalse(itr.hasNext());
        itr.add("d");
        assertFalse(itr.hasNext());

        assertEquals(listOf("a", "0", "b", "1", "c", "2", "d"), lst);
    }

    @Test
    public void testAddBackwards() throws Exception {
        testNext();

        itr.add("d");
        assertEquals("d", itr.previous());

        assertEquals("2", itr.previous());
        itr.add("c");
        assertEquals("c", itr.previous());
        assertEquals("1", itr.previous());
        itr.add("b");
        assertEquals("b", itr.previous());
        assertEquals("0", itr.previous());
        assertFalse(itr.hasPrevious());
        itr.add("a");
        assertTrue(itr.hasPrevious());
        assertEquals("a", itr.previous());
        assertFalse(itr.hasPrevious());

        assertEquals(listOf("a", "0", "b", "1", "c", "2", "d"), lst);
    }

    @Test(expected = IllegalStateException.class)
    public void testRemoveMoreThanOne() throws Exception {
        itr.next();
        itr.next();
        itr.remove();
        itr.remove();
    }

    @Test
    public void testAddMoreThanOne() throws Exception {
        itr.add("x");
        itr.add("y");

        assertEquals("y",itr.previous());
        assertEquals("x", itr.previous());
        assertEquals(listOf("x","y","0","1","2"), lst);
    }

    @Test(expected = IllegalStateException.class)
    public void testAddThenSet() {
        itr.next();
        itr.add("x");
        itr.set("y");
    }

    @Test(expected = IllegalStateException.class)
    public void testAddThenRemove() {
        itr.next();
        itr.add("x");
        itr.remove();
    }

    @Test
    public void testRemoveThenAdd() {
        itr.next();
        itr.remove();
        itr.add("x");
        assertEquals("x", itr.previous());
        assertEquals(listOf("x","1","2"),lst);
    }

    @Test(expected = IllegalStateException.class)
    public void testRemoveThenSet() {
        itr.next();
        itr.next();
        itr.remove();
        itr.set("y");
    }

    private static <T> List<T> listOf(T... contents) {
        return new LinkedList<T>(Arrays.asList(contents));
    }
}
