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
     * Return null if the list is empty. 
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
        while(trav != null && !key.equals(trav.key)){
            parent = trav;
            if(key.compareTo(trav.key) < 0){
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
            } else if(toDelete.key.compareTo(parent.key) < 0){
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
        List<Integer> array = new ArrayList<>();
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
        array = testTree.inorderRec();
        for(Integer i : array){
            System.out.print(i + " ");
        }
        System.out.println(" ");
        testTree.delete(4);
        testTree.delete(9);
        List<Integer> array1 = new ArrayList<>();
        array1 = testTree.inorderRec();
        for(Integer i : array1){
            System.out.print(i + " ");
        }
        System.out.println(" ");
        System.out.println(testTree.search(12));
        System.out.println(testTree.search(4));
        System.out.println(testTree.kthSmallest(3));
        
        BST<Integer,Integer> testTreeV = new BST<>();
        List<Integer> arrayV = new ArrayList<>();
        testTreeV.insert(2,5);
        testTreeV.insert(1,6);
        testTreeV.insert(4,7);
        testTreeV.insert(5,8);
        testTreeV.insert(9,9);
        testTreeV.insert(3,10);
        testTreeV.insert(6,11);
        testTreeV.insert(7,12);
        testTreeV.insert(10,13);
        testTreeV.insert(12,14);
        testTreeV.insert(11,15);
        arrayV = testTreeV.inorderRec();
        for(Integer i : arrayV){
            System.out.print(i + " ");
        }
        System.out.println(" ");
        testTreeV.delete(4);
        testTreeV.delete(9);
        List<Integer> array1V = new ArrayList<>();
        array1V = testTreeV.inorderRec();
        for(Integer i : array1V){
            System.out.print(i + " ");
        }
        System.out.println(" ");
        System.out.println(testTreeV.search(12));
        System.out.println(testTreeV.search(4));
        System.out.println(testTreeV.kthSmallest(3));

        BST<Double,Double> testTreeD = new BST<>();
        List<Double> arrayD = new ArrayList<>();
        testTreeD.insert(2d,2d);
        testTreeD.insert(1d,1d);
        testTreeD.insert(4d,4d);
        testTreeD.insert(5d,5d);
        testTreeD.insert(9d,9d);
        testTreeD.insert(3d,3d);
        testTreeD.insert(6d,6d);
        testTreeD.insert(7d,7d);
        testTreeD.insert(10d,10d);
        testTreeD.insert(12d,12d);
        testTreeD.insert(11d,11d);
        arrayD = testTreeD.inorderRec();
        for(Double i : arrayD){
            System.out.print(i + " ");
        }
        System.out.println(" ");
        testTreeD.delete(4d);
        testTreeD.delete(9d);
        List<Double> array1D = new ArrayList<>();
        array1D = testTreeD.inorderRec();
        for(Double i : array1D){
            System.out.print(i + " ");
        }
        System.out.println(" ");
        System.out.println(testTreeD.search(12d));
        System.out.println(testTreeD.search(4d));
        System.out.println(testTreeD.kthSmallest(3));

        BST<String,String> testTreeS = new BST<>();
        List<String> arrayS = new ArrayList<>();
        testTreeS.insert("2","2");
        testTreeS.insert("1","1");
        testTreeS.insert("4","4");
        testTreeS.insert("5","5");
        testTreeS.insert("9","9");
        testTreeS.insert("3","3");
        testTreeS.insert("6","6");
        testTreeS.insert("7","7");
        testTreeS.insert("10","10");
        testTreeS.insert("12","12");
        testTreeS.insert("11","11");
        arrayS = testTreeS.inorderRec();
        for(String i : arrayS){
            System.out.print(i + " ");
        }
        System.out.println(" ");
        testTreeS.delete("4");
        testTreeS.delete("9");
        List<String> array1S = new ArrayList<>();
        array1S = testTreeS.inorderRec();
        for(String i : array1S){
            System.out.print(i + " ");
        }
        System.out.println(" ");
        System.out.println(testTreeS.search("12"));
        System.out.println(testTreeS.search("4"));
        System.out.println(testTreeS.kthSmallest(3));
    }
} 