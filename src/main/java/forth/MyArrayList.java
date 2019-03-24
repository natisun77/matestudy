package forth;

public class MyArrayList<T> implements List<T> {
    private Object[] arr;
    private int counter;
    private static final int INIT_SIZE = 10;

    public MyArrayList() {
        arr = new Object[INIT_SIZE];
    }

    public T get(int index) {
        if (index < 0 || index >= counter) {
            throw new InvalidIndexException("You input invalid index " + index);
        } else {
            return (T) arr[index];
        }
    }

    public void add(T t) {
        if (arr.length == counter) {
            Object[] arrIncreased = new Object[arr.length * 3 / 2];
            System.arraycopy(arr, 0, arrIncreased, 0, arr.length - 1);
            arr = arrIncreased;
        }
        arr[counter] = t;
        counter++;
    }


    public void remove(int index) {
        if (index < 0 || index >= counter) {
            throw new InvalidIndexException("You input invalid index " + index);
        } else {
            System.arraycopy(arr, index + 1, arr, index, counter - index - 1);
            arr[counter] = null;
            counter--;
        }
    }

    public int size() {
        return counter;
    }

    public void clear() {
        for (int i = 0; i < counter; i++) {
            arr[i] = null;
        }
        counter = 0;
    }
}
