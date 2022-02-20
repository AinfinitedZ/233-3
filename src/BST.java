import java.util.ArrayList;
import java.util.List;

public class BST<T extends Comparable<T>,V> implements tree<T,V>{
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

    public BST(BN root){
        this.root = root;
    } 
    public BST(){
        this.root = null;
    }

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
        } else{
            parent.right = node;
        }
    }

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

    public V search(T key){
        BN ptr = root;
        while(ptr.left != null || ptr.right != null){
            if(key.compareTo(ptr.key) < 0){
                ptr = ptr.left;
            } else if(key.compareTo(ptr.key) > 0){
                ptr = ptr.right;
            } else if(key.compareTo(ptr.key) == 0){
                return ptr.value;
            }
        }
        return key.equals(ptr.key) ? ptr.value : null;
    }

    public void delete(T key){

    }

    public V kthSmallest(int k){
        return root.value;
    }
} 