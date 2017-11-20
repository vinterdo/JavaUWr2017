package pl.vinterdo.algorithm;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BinarySearchTreeTest {

    private BinarySearchTree<Integer, String> bstMock() {
        BinarySearchTree<Integer, String> bst = new BinarySearchTree<>();
        bst.put(10, "Ten");
        bst.put(15, "Fifteen");
        bst.put(0, "Zero");
        bst.put(12, "Twelve");
        bst.put(23, "TwentyThree");
        bst.put(2, "Two");
        return bst;
    }

    @Test
    public void insertGetTest(){
        BinarySearchTree<Integer, String> bst = bstMock();

        assertThat(bst.min(), is(0));
        assertThat(bst.max(), is(23));
        assertThat(bst.get(12), is("Twelve"));
        assertThat(bst.get(23), is("TwentyThree"));
        assertThat(bst.get(10), is("Ten"));
        assertNull(bst.get(11));
        assertNull(bst.get(100));
        assertNull(bst.get(-10));

        assertThat(bst.size(), is(6));

        bst.clear();

        assertThat(bst.size(), is(0));

        assertNull(bst.get(10));
        assertNull(bst.get(0));
        assertNull(bst.get(-10));
    }


    @Test
    public void removeTest() {
        BinarySearchTree<Integer, String> bst = bstMock();
        bst.remove(10);
        bst.remove(2);
        bst.remove(12);
        bst.remove(-10);

        assertNull(bst.get(10));
        assertNull(bst.get(2));
        assertNull(bst.get(12));
        assertNull(bst.get(-10));

        assertThat(bst.min(), is(0));
        assertThat(bst.max(), is(23));
        assertThat(bst.get(23), is("TwentyThree"));
        assertThat(bst.size(), is(3));
    }
}