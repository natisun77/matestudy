package forth;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

public class MyLinkedListTest extends ListTest {

    @Override
    public void initList() {
        list = new MyLinkedList<>();
    }
}
