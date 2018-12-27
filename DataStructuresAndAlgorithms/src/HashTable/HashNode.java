package HashTable;

public class HashNode<K, V> {
    public K key;
    public V value;

    public HashNode<K, V> nextNode;

    // constructor
    public HashNode(K key, V value){
        this.key = key;
        this.value = value;
    }
}
