import java.util.ArrayList;
import java.util.List;

public class BST<T extends Comparable<T>,V> implements tree<T,V>{
    /**
     * nested class for definition of nodes. 
     */
    private class BN{
        private T key;
        private V value;
        private BN left = null;
        private BN right = null;
        public BN(T key , V value){
            this.key = key;
            this.value = value;
        }
        public BN(){
            this.key = null;
            this.value = null;
        }
    }

    private BN root;
    private int elements;

    public BST(BN root){
        this.root = root;
    } 
    public BST(){
        this.root = null;
    }
    
    
    /** 
     * insert specific node with assigned key and value. 
     * @param key variable determine the relation of this node.
     * @param value variable that aimed to stored. 
     */
    public void insert(T key, V value){
        BN parent = null;
        BN ptr = root;
        while(ptr != null){
            parent = ptr;
            if(key.compareTo(ptr.key) < 0){
                ptr = ptr.left;
            }
            else{
                ptr = ptr.right;
            }
        }
        BN node = new BN(key, value);
        if(parent == null){
            root = node;
        } else if(key.compareTo(parent.key) < 0){
            parent.left = node;
        } else if(key.compareTo(parent.key) > 0){
            parent.right = node;
        } else {;}
        elements ++;
    }

    
    /** 
     * Generate a List<V> that its elements were arranged inorderly. 
     * @return List<V> Consist of elements of tree.
     */
    public List<V> inorderRec(){
        List<V> list = new ArrayList<>();
        if(root != null) return inorderRecTree(list, root);
        return list;
    }

    private List<V> inorderRecTree(List<V> list, BN root){
        if(root.left != null) inorderRecTree(list, root.left);
        list.add(root.value);
        if(root.right != null) inorderRecTree(list, root.right);
        return list;
    }

    
    /** 
     * Search for node with specific key. Return its value when found and 
     * null when not found.
     * @param key key that denote one node.
     * @return V value of that node.
     */
    public V search(T key){
        BN ptr = root;
        if(ptr == null) return null;
        while(ptr.left != null || ptr.right != null){
            if(key.compareTo(ptr.key) < 0){
                ptr = ptr.left;
            } else if(key.compareTo(ptr.key) > 0){
                ptr = ptr.right;
            } else if(key.equals(ptr.key)){
                return ptr.value;
            }
        }
        return key.equals(ptr.key) ? ptr.value : null;
    }

    
    /** 
     * Detele node with specific key. Do nothing when not found. 
     * @param key key denoted one node. 
     */
    public void delete(T key){
        BN parent = null;
        BN trav   = root;
        while(trav != null && trav.key != key){
            parent = trav;
            if(key.compareTo(trav.key) <= 0){
                trav = trav.left;
            }
            else{ 
                trav = trav.right;
            }
        }
        if(trav != null) deleteBN(trav, parent);

    }

    private void deleteBN(BN toDelete, BN parent){
        if(toDelete.left == null || toDelete.right == null){
            BN toDeleteChild = null;
            if(toDelete.left != null){
                toDeleteChild = toDelete.left;
            }
            else{
                toDeleteChild = toDelete.right;
            }
            if(toDelete.equals(root)){
                root = toDeleteChild;
            } else if(toDelete.key.compareTo(parent.key) <= 0){
                parent.left = toDeleteChild;
            } else {
                parent.right = toDeleteChild;
            }
        } else {
            BN replaceParent = toDelete;
            BN replace = toDelete.right;
            while(replace.left != null){
                replaceParent = replace;
                replace = replace.left;
            }
            toDelete.key = replace.key;
            toDelete.value = replace.value;
            deleteBN(replace, replaceParent);
        }
        elements--;
    }

    
    /** 
     * Found node that k-th smallest element in the BST. Return null
     * if not found.
     * @param k
     * @return V
     */
    public V kthSmallest(int k){
        List<V> result = inorderRec();
        return k < this.elements ? result.get(k - 1) : null;
    }

    public static void main(String[] args) {
        BST<Integer,Integer> testTree = new BST<>();
        testTree.insert(2,2);
        testTree.insert(1,1);
        testTree.insert(4,4);
        testTree.insert(5,5);
        testTree.insert(9,9);
        testTree.insert(3,3);
        testTree.insert(6,6);
        testTree.insert(7,7);
        testTree.insert(10,10);
        testTree.insert(12,12);
        testTree.insert(11,11);
        testTree.delete(4);
        testTree.delete(9);
        List<Integer> array = new ArrayList<>();
        array = testTree.inorderRec();
        for(Integer i : array){
            System.out.println(i);
        }
        System.out.println(testTree.search(12));
        testTree.search(4);
        System.out.println(testTree.kthSmallest(3));
    }
} 