package datastructures.stacksqueueshashmapshashfunctions;
import java.util.LinkedList;

/**
 * Implement a Custom Hash Map
 * Problem: Design and implement a basic hash map class with operations for
 * insertion, deletion, and retrieval.
 * Approach: Use an array of linked lists to handle collisions using separate
 * chaining.
 */
public class CustomHashMap<K, V> {

    // Entry class to store key-value pairs
    private static class Entry<K, V> {
        K key;
        V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private static final int DEFAULT_CAPACITY = 16;
    private static final double LOAD_FACTOR = 0.75;

    private LinkedList<Entry<K, V>>[] buckets;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public CustomHashMap() {
        this.capacity = DEFAULT_CAPACITY;
        this.buckets = new LinkedList[capacity];
        this.size = 0;

        // Initialize each bucket
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    // Hash function to get bucket index
    private int getBucketIndex(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % capacity;
    }

    // Put operation - insert or update key-value pair
    public void put(K key, V value) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];

        // Check if key already exists, update value
        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                System.out.println("Updated: " + key + " -> " + value);
                return;
            }
        }

        // Key doesn't exist, add new entry
        bucket.add(new Entry<>(key, value));
        size++;
        System.out.println("Inserted: " + key + " -> " + value);

        // Check if rehashing is needed
        if ((double) size / capacity > LOAD_FACTOR) {
            rehash();
        }
    }

    // Get operation - retrieve value by key
    public V get(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }

        return null; // Key not found
    }

    // Remove operation - delete key-value pair
    public V remove(K key) {
        int bucketIndex = getBucketIndex(key);
        LinkedList<Entry<K, V>> bucket = buckets[bucketIndex];

        for (Entry<K, V> entry : bucket) {
            if (entry.key.equals(key)) {
                V value = entry.value;
                bucket.remove(entry);
                size--;
                System.out.println("Removed: " + key + " -> " + value);
                return value;
            }
        }

        System.out.println("Key not found: " + key);
        return null;
    }

    // Check if key exists
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    // Get size
    public int size() {
        return size;
    }

    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Rehash when load factor exceeds threshold
    @SuppressWarnings("unchecked")
    private void rehash() {
        System.out.println("\nRehashing... Old capacity: " + capacity);

        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
        capacity *= 2;
        buckets = new LinkedList[capacity];
        size = 0;

        // Initialize new buckets
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }

        // Rehash all entries
        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            for (Entry<K, V> entry : bucket) {
                put(entry.key, entry.value);
            }
        }

        System.out.println("Rehashing complete. New capacity: " + capacity + "\n");
    }

    // Display all entries
    public void display() {
        System.out.println("\n=== HashMap Contents ===");
        System.out.println("Size: " + size + ", Capacity: " + capacity);

        for (int i = 0; i < capacity; i++) {
            if (!buckets[i].isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Entry<K, V> entry : buckets[i]) {
                    System.out.print("[" + entry.key + " -> " + entry.value + "] ");
                }
                System.out.println();
            }
        }
        System.out.println("========================\n");
    }

    public static void main(String[] args) {
        System.out.println("=== Custom HashMap Implementation ===\n");

        CustomHashMap<String, Integer> map = new CustomHashMap<>();

        // Insert operations
        System.out.println("--- Insertion Operations ---");
        map.put("Apple", 10);
        map.put("Banana", 20);
        map.put("Orange", 30);
        map.put("Mango", 40);
        map.put("Grapes", 50);

        map.display();

        // Get operations
        System.out.println("--- Get Operations ---");
        System.out.println("Apple: " + map.get("Apple"));
        System.out.println("Banana: " + map.get("Banana"));
        System.out.println("Cherry: " + map.get("Cherry"));

        // Update operation
        System.out.println("\n--- Update Operation ---");
        map.put("Apple", 100);

        map.display();

        // Remove operations
        System.out.println("--- Remove Operations ---");
        map.remove("Banana");
        map.remove("Cherry");

        map.display();

        // Contains key
        System.out.println("--- Contains Key ---");
        System.out.println("Contains 'Apple': " + map.containsKey("Apple"));
        System.out.println("Contains 'Banana': " + map.containsKey("Banana"));

        // Add more elements to trigger rehashing
        System.out.println("\n--- Adding More Elements ---");
        map.put("Pineapple", 60);
        map.put("Watermelon", 70);
        map.put("Strawberry", 80);
        map.put("Blueberry", 90);
        map.put("Raspberry", 100);
        map.put("Blackberry", 110);
        map.put("Kiwi", 120);
        map.put("Peach", 130);

        map.display();
    }
}
