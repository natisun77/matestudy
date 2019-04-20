package twelveth;

import java.util.Arrays;

public class MyHashMap<K, V> {
    public static final double LOAD_FACTOR = 0.75;
    public static final int MAP_INITIAL_SIZE = 16;
    private Node<K, V>[] array;
    private int numberOfNodes;
    private int bucketsOccupied;

    public MyHashMap() {
        array = new Node[MAP_INITIAL_SIZE];
    }

    static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> nextNode;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", nextNode=" + nextNode +
                    '}';
        }
    }

    public void put(K key, V value) {
        if (bucketsOccupied / array.length >= LOAD_FACTOR) {
            Node<K, V>[] arrayNew = new Node[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                arrayNew[getNumberOfBucket(array[i].key.hashCode())] = array[i];

                int hashCodeOfNode = array[i].key.hashCode();
                int indexOfBucket = getNumberOfBucket(hashCodeOfNode);
                arrayNew[indexOfBucket] = array[i];
            }
            array = arrayNew;
        }
        int hashCodeOfNode = key.hashCode();
        int numerOfBucket = getNumberOfBucket(hashCodeOfNode);
        Node<K, V> currentNode = array[numerOfBucket];
        if (currentNode == null) {
            currentNode = array[numerOfBucket] = new Node<K, V>(key, value);
            bucketsOccupied++;
        } else {
            while (currentNode != null) {
                if (currentNode.key.equals(key)) {
                    currentNode.value = value;
                    break;
                } else if (currentNode.nextNode == null) {
                    currentNode.nextNode = new Node<K, V>(key, value);
                    break;
                } else {
                    currentNode = currentNode.nextNode;
                }
            }
        }

        numberOfNodes++;
    }

    public void remove(K key) {
        int hashCodeOfNode = key.hashCode();
        int numberOfBucket = getNumberOfBucket(hashCodeOfNode);
        Node<K, V> currentNode = array[numberOfBucket];
        if (currentNode != null && currentNode.key.equals(key)) {
            if (currentNode.nextNode == null) {
                bucketsOccupied--;
            }
            array[numberOfBucket] = currentNode.nextNode;
            numberOfNodes--;
        } else if (currentNode != null) {
            while (currentNode.nextNode != null) {
                if (currentNode.nextNode.key.equals(key)) {
                    currentNode.nextNode = currentNode.nextNode.nextNode;
                    numberOfNodes--;
                    break;
                } else {
                    currentNode = currentNode.nextNode;
                }
            }
        }
    }

    public void clear() {
        array = new Node[MAP_INITIAL_SIZE];
        numberOfNodes = 0;
        bucketsOccupied = 0;
    }

    public int size() {
        return numberOfNodes;
    }

    public V get(K key) {
        int hashCodeOfNode = key.hashCode();
        int numberOfBucket = getNumberOfBucket(hashCodeOfNode);
        Node<K, V> currentNode = array[numberOfBucket];
        while (currentNode != null) {
            if (currentNode.key.equals(key)) {
                return currentNode.value;
            } else {
                currentNode = currentNode.nextNode;
            }
        }
        return null;
    }

    private int getNumberOfBucket(int hashCodeOfNode) {
        return Math.abs(hashCodeOfNode) % array.length;
    }

    @Override
    public String toString() {
        return "MyHashMap{" +
                "array=" + Arrays.toString(array) +
                '}';
    }
}
