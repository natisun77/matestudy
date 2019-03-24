package forth;

public class MainList {


    public static void main(String[] args) {
        testArrayList();
        testLinkedList();
        testStack();
    }

    private static void testArrayList() {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            myArrayList.add(i);
        }
        System.out.println(myArrayList.size());
        System.out.println(myArrayList.get(18));
        System.out.println(myArrayList.get(16));
        try {
            myArrayList.remove(25);
        } catch (InvalidIndexException e) {
            System.out.println("Сaught except due to incorrect index.");
        }
        myArrayList.remove(0);
        System.out.println(myArrayList.size());
        try {
            myArrayList.get(166);
        } catch (InvalidIndexException e) {
            System.out.println("Сaught except due to incorrect index.");
        }
        System.out.println(myArrayList.get(17));
        System.out.println(myArrayList.get(18));

    }

    private static void testLinkedList() {
        MyLinkedList<Integer> myLinkedList = new MyLinkedList<>();
        for (int i = 0; i < 20; i++) {
            myLinkedList.add(i);
        }
        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.get(15));
        System.out.println(myLinkedList.get(18));
        myLinkedList.remove(0);
        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.get(1));
        myLinkedList.remove(0);
        System.out.println(myLinkedList.size());
        System.out.println(myLinkedList.get(1));
        myLinkedList.clear();
        System.out.println(myLinkedList.size());

        myLinkedList.add(5);
        System.out.println(myLinkedList.size());

        myLinkedList.remove(0);
        System.out.println(myLinkedList.size());

        myLinkedList.add(5);
        myLinkedList.add(6);
        myLinkedList.remove(1);
        System.out.println(myLinkedList.size());

        myLinkedList.add(6);
        myLinkedList.remove(0);
        System.out.println(myLinkedList.size());

        myLinkedList.remove(0);
        System.out.println(myLinkedList.size());

        myLinkedList.add(100);
        System.out.println(myLinkedList.size());
    }

    private static void testStack() {
        MyStack<Integer> myStack = new MyStack<>();
        for (int i = 0; i < 20; i++) {
            myStack.push(i);
        }
        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        myStack.pop();
        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        myStack.remove(1);
        System.out.println();
        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        myStack.clear();
        System.out.println(myStack.size());
        System.out.println(myStack.peek());
        System.out.println(myStack.pop());
    }
}
