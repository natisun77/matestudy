package twelveth;

import forth.MyArrayList;
import org.junit.Test;

import static org.junit.Assert.*;

public class MyArrayListTest extends ListTest {

    @Override
    public void initList() {
        list = new MyArrayList<>();
    }
}
