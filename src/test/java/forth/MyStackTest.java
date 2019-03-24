package forth;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class MyStackTest {
    private MyStack<Integer> myStack;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void initStack() {
        myStack = new MyStack<>();
    }

    @Test
    public void pushAndPeek() {
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals(3, (long) myStack.peek());
        myStack.push(4);
        assertEquals(4, (long) myStack.peek());
        myStack.push(5);
        assertEquals(5, (long) myStack.peek());
    }

    @Test
    public void remove() {
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.push(4);
        assertEquals(4, (long) myStack.peek());
        myStack.remove(5);
        assertEquals(4, (long) myStack.peek());
        myStack.remove(2);
        assertEquals(2, (long) myStack.peek());
    }

    @Test
    public void clear() {
        assertEquals(0, myStack.size());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals(3, myStack.size());
        myStack.clear();
        assertEquals(0, myStack.size());
    }

    @Test
    public void size() {
        assertEquals(0, myStack.size());
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals(3, myStack.size());
        myStack.push(4);
        myStack.push(5);
        assertEquals(5, myStack.size());
    }

    @Test
    public void pop() {
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        assertEquals(3, (long) myStack.peek());
        myStack.pop();
        assertEquals(2, (long) myStack.peek());
        myStack.push(4);
        myStack.push(5);
        assertEquals(5, (long) myStack.peek());
        myStack.pop();
        assertEquals(4, (long) myStack.peek());
    }
}