package forth;

public class MyLinkedList<T> implements List<T> {
    private int counter;
    private Node<T> first;
    private Node<T> last;

    private static class Node<T> {
        T element;
        Node<T> next;
        Node<T> previous;

        private Node(T element) {
            this.element = element;
        }
    }

    public T get(int index) {
        if (index >= counter || index < 0) {
            throw new InvalidIndexException("You input invalid index " + index);
        } else {
            Node<T> currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            return currentNode.element;
        }
    }

    public void add(T t) {
        if (counter == 0) {
            Node<T> node = new Node<>(t);
            first = node;
            last = node;
        } else {
            Node<T> node = new Node<>(t);
            node.previous = last;
            last.next = node;
            last = node;
        }
        counter++;
    }

    public void remove(int index) {
        if (index >= counter || index < 0) {
            throw new InvalidIndexException("You input invalid index " + index);
        } else {
            Node<T> currentNode = first;
            for (int i = 0; i < index; i++) {
                currentNode = currentNode.next;
            }
            if (currentNode != first) {
                currentNode.previous.next = currentNode.next;
            } else {
                first = currentNode.next;
            }
            if (currentNode != last) {
                currentNode.next.previous = currentNode.previous;
            } else {
                last = currentNode.previous;
            }
            counter--;
        }
    }

    public int size() {
        return counter;
    }

    public void clear() {
        first = null;
        last = null;
        counter = 0;
    }
}
