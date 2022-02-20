import java.util.List;

public interface tree <T extends Comparable<T>,V> {
    void insert(T key, V value);
    V search(T key);
    void delete(T key);
    List<V> inorderRec();
    V kthSmallest(int k);
}


