package forth;

public class MyStack<T> {
    private static final int INIT_SIZE = 10;
    private Object[] arr;
    private int counter;

    public MyStack() {
        arr = new Object[INIT_SIZE];
    }

    public void push(T t) {
        if (arr.length == counter) {
            Object[] arrIncreased = new Object[arr.length * 3 / 2];
            System.arraycopy(arr, 0, arrIncreased, 0, arr.length - 1);
            arr = arrIncreased;
        }
        arr[counter] = t;
        counter++;
    }

    public void remove(int number) {
        if (number >= 0 && number <= counter) {
            for (int i = 0; i < number; i++) {
                pop();
            }
        } else {
            System.out.println("Ckeck number " + number);
        }
    }

    public void clear() {
        arr = new Object[INIT_SIZE];
        counter = 0;
    }

    public int size() {
        return counter;
    }

    public T peek() {
        if (counter > 0) {
            return (T) arr[counter - 1];
        }
        return null;
    }

    public T pop() {
        if (counter > 0) {
            T element = (T) arr[counter - 1];
            arr[counter - 1] = null;
            counter--;
            return element;
        }
        return null;
    }
}
