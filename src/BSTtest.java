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
    public void testDelete(){
        BST<Integer, Integer> test = new BST<>();
        ArrayList<Integer> equalArray = new ArrayList<>();
        test.delete(10);
        test.insert(3, 26);
        test.delete(3);
        assertEquals(equalArray, test.inorderRec());
        test.insert(2, 80);
        test.insert(4, 90);
        test.insert(5, 100);
        test.delete(5);
        equalArray.add(80);
        equalArray.add(90);
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
        tree<Integer, Integer> test = new BST<>();
        assertEquals(null, test.search(1));
        test.insert(3, 26);
        test.search(3);
        assertTrue(test.search(3).equals(26));     
        test.insert(2, 80);
        test.insert(4, 90);
        test.insert(5, 100);
        assertTrue(test.search(5).equals(100));
        assertEquals(null, test.search(1));
    }

    @Test
    public void testKSmallest(){
        tree<Integer, Integer> test = new BST<>();
        test.insert(3, 26);
        test.insert(2, 88);
        test.insert(4, 98);
        test.insert(5, 100);
        Integer value = test.kthSmallest(3);
        Integer equal = 98;
        assertTrue(value.compareTo(equal) == 0);
    }
}