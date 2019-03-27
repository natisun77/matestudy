package forth;

public interface List<T> {
    T get(int index);

    void add(T element);

    void remove(int index);

    int size();

    void clear();

}