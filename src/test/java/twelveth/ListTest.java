package twelveth;

import forth.InvalidIndexException;
import forth.List;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public abstract class ListTest {
    protected List<Integer> list;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public abstract void initList();

    @Test
    public void testAddAndGet() {
        list.add(5);
        list.add(10);

        assertEquals(5, (long) list.get(0));
        assertEquals(10, (long) list.get(1));

        exception.expect(InvalidIndexException.class);
        list.get(2);
    }

    @Test
    public void testRemove() {
        list.add(5);
        list.add(10);
        list.add(15);

        list.remove(0);
        assertEquals(10, (long) list.get(0));
        list.add(20);
        assertEquals(20, (long) list.get(2));
        list.remove(2);
        exception.expect(InvalidIndexException.class);
        list.get(2);
        exception.expect(InvalidIndexException.class);
        list.get(5);
    }

    @Test
    public void testSize() {
        list.add(5);
        list.add(10);
        list.add(15);
        assertEquals(3, list.size());
        list.add(20);
        list.add(25);
        assertEquals(5, list.size());
        list.remove(0);
        list.remove(0);
        list.remove(2);
        assertEquals(2, list.size());
        list.remove(0);
        list.remove(0);
        assertEquals(0, list.size());
    }

    @Test
    public void testClear() {
        list.add(5);
        list.add(10);
        list.add(15);
        assertEquals(3, list.size());
        list.clear();
        assertEquals(0, list.size());
        list.add(20);
        list.add(20);
        list.clear();
        assertEquals(0, list.size());
    }
}