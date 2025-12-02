import java.util.LinkedList;
// --- 3. Implementation 1: Unsorted List (LinkedList) ---
// Insert: O(1) | RemoveMin: O(n)
class UnsortedListPQ<K extends Comparable<K>, V> implements PriorityQueue<K, V> {
    private LinkedList<MyEntry<K, V>> list = new LinkedList<>();

    public boolean isEmpty() { return list.isEmpty(); }

    public void insert(K key, V value) {
        list.addLast(new MyEntry<>(key, value));
    }

    public MyEntry<K, V> min() {
        if (isEmpty()) return null;
        MyEntry<K, V> minEntry = list.getFirst();
        for (MyEntry<K, V> entry : list) {
            if (entry.compareTo(minEntry) < 0) {
                minEntry = entry;
            }
        }
        return minEntry;
    }

    public MyEntry<K, V> removeMin() {
        if (isEmpty()) return null;
        MyEntry<K, V> minEntry = min();
        list.remove(minEntry);
        return minEntry;
    }
}
