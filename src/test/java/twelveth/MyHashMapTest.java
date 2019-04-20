package twelveth;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyHashMapTest {
    private MyHashMap<Integer, String> myHashMap;

    @Before
    public void initHashMap() {
        myHashMap = new MyHashMap<>();
    }

    @Test
    public void putAndGet() {
        myHashMap.put(1, "Ann");
        myHashMap.put(2, "Ron");
        myHashMap.put(3, "Kate");
        myHashMap.put(4, "Tim");

        assertEquals(myHashMap.get(2), "Ron");
        assertEquals(myHashMap.get(4), "Tim");
        assertEquals(myHashMap.get(5), null);
        assertNull(myHashMap.get(7));
    }

    @Test
    public void remove() {
        myHashMap.put(1, "Ann");
        myHashMap.put(2, "Ron");
        myHashMap.put(3, "Kate");
        assertEquals(3, myHashMap.size());
        myHashMap.remove(2);
        assertEquals(2, myHashMap.size());
        assertNull(myHashMap.get(2));
        assertEquals(myHashMap.get(1), "Ann");
    }

    @Test
    public void clear() {
        myHashMap.put(1, "Ann");
        myHashMap.put(2, "Ron");
        myHashMap.put(3, "Kate");
        assertEquals(3, myHashMap.size());
        myHashMap.clear();
        assertEquals(0, myHashMap.size());
        myHashMap.put(3, "Kate");
        myHashMap.put(4, "Tim");
        assertEquals(2, myHashMap.size());
    }

    @Test
    public void size() {
        myHashMap.put(1, "Ann");
        myHashMap.put(2, "Ron");
        myHashMap.put(3, "Kate");
        myHashMap.put(4, "Tim");
        assertEquals(4, myHashMap.size());
        myHashMap.clear();
        assertEquals(0, myHashMap.size());
        myHashMap.put(1, "Ann");
        myHashMap.put(2, "Ron");
        assertEquals(2, myHashMap.size());
    }
}
