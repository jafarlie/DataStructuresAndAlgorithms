package HashTable;

import java.util.ArrayList;

// HashTable.Map class that will represent the hash table
public class Map<K, V> {
    private ArrayList<HashNode<K, V>> bucketArr;

    private int numBuckets;

    private int sizeOfArrayList;

    public Map(){
        bucketArr = new ArrayList<>();
        numBuckets = 10;
        sizeOfArrayList = 0;

        // create empty chains
        for (int i = 0; i < numBuckets; i++){
            bucketArr.add(null);
        }
    }

    public int size(){
        return this.sizeOfArrayList;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    // our hash function, that will determine the index slot for the key
    private int getBucketIndex(K key){
        int hashCode = key.hashCode();
        return hashCode % numBuckets;
    }

    public V getValue(K key){
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArr.get(bucketIndex);

        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }else{
                head = head.nextNode;
            }
        }
        return null;
    }

    public V removeValue(K key){
        int bucketIndex = getBucketIndex(key);

        // head of the chain
        HashNode<K, V> head = bucketArr.get(bucketIndex);
        HashNode<K, V> previousNode = null;
        while(head != null){
            // found a key
            if(head.key.equals(key)){
                break;
            }
            previousNode = head;
            head = head.nextNode;
        }
        // did not find the key
        if(head == null){
            return null;
        }
        sizeOfArrayList -= 1;
        // now remove the key
        if (previousNode != null){
            previousNode.nextNode = head.nextNode;
        }else{
            bucketArr.set(bucketIndex, head.nextNode);
        }
        return head.value;
    }

    public void add(K key, V value){
        int bucketIndex = getBucketIndex(key);
        HashNode<K, V> head = bucketArr.get(bucketIndex);

        // check if the key is already there
        while( head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }else{
                head = head.nextNode;
            }
        }
        // insert key in the chain
        sizeOfArrayList += 1;
        head = bucketArr.get(bucketIndex);
        HashNode<K,V> newNode = new HashNode<K,V>(key, value);
        newNode.nextNode = head;
        bucketArr.set(bucketIndex, newNode);

        // check if the load factor goes beyond the threshold, double the hashtable in size
        if((1.0*sizeOfArrayList)/numBuckets >= 0.7){
            ArrayList<HashNode<K,V>> temporary = bucketArr;
            bucketArr = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            this.sizeOfArrayList = 0;
            for(int i=0; i < numBuckets; i++){
                bucketArr.add(null);
            }
            for(HashNode<K,V> headNode: temporary){
                while(headNode!=null){
                    this.add(headNode.key, headNode.value);
                    headNode = headNode.nextNode;
                }
            }

        }
    }

    public static void main(String[] args)
    {
        Map<String, Integer>map = new Map<>();
        map.add("this",1 );
        map.add("coder",2 );
        map.add("this",4 );
        map.add("hi",5 );
        System.out.println(map.size());
        System.out.println(map.removeValue("this"));
        System.out.println(map.removeValue("this"));
        System.out.println(map.size());
        System.out.println(map.isEmpty());
    }
}
