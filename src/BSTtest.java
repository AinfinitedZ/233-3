import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

public class BSTtest{

    @Test
    public void insertTest(){
        BST<Integer, Integer> test = new BST<>();
        ArrayList<Integer> equalArray = new ArrayList<>();
        assertEquals(equalArray, test.inorderRec());
        test.insert(3, 26);
        equalArray.add(26);
        assertEquals(equalArray, test.inorderRec());     
        test.insert(2, 80);
        test.insert(4, 90);
        test.insert(5, 100);
        equalArray.clear();
        equalArray.add(80);
        equalArray.add(26);
        equalArray.add(90);
        equalArray.add(100);
        test.inorderRec();
        assertEquals(equalArray, test.inorderRec());
    }

    @Test
    public void testInOrderRec(){
        BST<Integer, Integer> test = new BST<>();
        ArrayList<Integer> equalArray = new ArrayList<>();
        assertEquals(equalArray, test.inorderRec());
        test.insert(3, 26);
        equalArray.add(26);
        assertEquals(equalArray, test.inorderRec());     
        test.insert(2, 80);
        test.insert(4, 90);
        test.insert(5, 100);
        equalArray.clear();
        equalArray.add(80);
        equalArray.add(26);
        equalArray.add(90);
        equalArray.add(100);
        test.inorderRec();
        assertEquals(equalArray, test.inorderRec());
    }

    @Test
    public void testSearch(){
        BST<Integer, Integer> test = new BST<>();
        test.insert(3, 26);
        test.search(3);
        assertTrue(test.search(3).equals(26));     
        test.insert(2, 80);
        test.insert(4, 90);
        test.insert(5, 100);
        assertTrue(test.search(5).equals(100));
        assertEquals(null, test.search(1));
    }
}