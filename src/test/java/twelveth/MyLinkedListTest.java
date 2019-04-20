package twelveth;

import forth.ListTest;
import forth.MyLinkedList;

public class MyLinkedListTest extends ListTest {

    @Override
    public void initList() {
        list = new MyLinkedList<>();
    }
}
