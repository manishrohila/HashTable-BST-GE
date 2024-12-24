import java.util.LinkedList;

class MyMapNode<K, V> {
    K key;
    V value;
    MyMapNode<K, V> next;

    public MyMapNode(K key, V value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class HashTable<K, V> {
    private final int size;
    private final LinkedList<MyMapNode<K, V>>[] buckets;

    public HashTable(int size) {
        this.size = size;
        this.buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    private int getBucketIndex(K key) {
        int hashCode = Math.abs(key.hashCode());
        return hashCode % size;
    }

    public void add(K key, V value) {
        int index = getBucketIndex(key);
        LinkedList<MyMapNode<K, V>> bucket = buckets[index];

        for (MyMapNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        bucket.add(new MyMapNode<>(key, value));
    }

    public V get(K key) {
        int index = getBucketIndex(key);
        LinkedList<MyMapNode<K, V>> bucket = buckets[index];

        for (MyMapNode<K, V> node : bucket) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }

        return null;
    }

    public void remove(K key) {
        int index = getBucketIndex(key);
        LinkedList<MyMapNode<K, V>> bucket = buckets[index];

        bucket.removeIf(node -> node.key.equals(key));
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            LinkedList<MyMapNode<K, V>> bucket = buckets[i];
            if (!bucket.isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (MyMapNode<K, V> node : bucket) {
                    System.out.print("(" + node.key + ", " + node.value + ") -> ");
                }
                System.out.println("null");
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        // UC1: Finding frequency of words in a sentence
        String sentence = "To be or not to be";
        HashTable<String, Integer> hashTable1 = new HashTable<>(10);
        for (String word : sentence.split(" ")) {
            Integer count = hashTable1.get(word);
            hashTable1.add(word, (count == null) ? 1 : count + 1);
        }
        System.out.println("UC1: Word frequencies in the sentence");
        hashTable1.display();

        // UC2: Finding frequency of words in a large paragraph
        String paragraph = "Paranoids are not paranoid because they are paranoid but because they keep putting themselves deliberately into paranoid avoidable situations";
        HashTable<String, Integer> hashTable2 = new HashTable<>(20);
        for (String word : paragraph.split(" ")) {
            Integer count = hashTable2.get(word);
            hashTable2.add(word, (count == null) ? 1 : count + 1);
        }
        System.out.println("\nUC2: Word frequencies in the paragraph");
        hashTable2.display();

        // UC3: Removing the word "avoidable"
        hashTable2.remove("avoidable");
        System.out.println("\nUC3: Word frequencies after removing 'avoidable'");
        hashTable2.display();
    }
}
