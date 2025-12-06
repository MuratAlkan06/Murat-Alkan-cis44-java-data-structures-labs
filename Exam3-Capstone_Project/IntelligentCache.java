import java.util.HashMap;
import java.util.Map;

/**
 * Option C - Intelligent Cache
 */
public class IntelligentCache {
    private static class CacheNode {
        int key;
        Object value;
        CacheNode prev;
        CacheNode next;

        CacheNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, CacheNode> map;
    private CacheNode head; 
    private CacheNode tail; 
    
    public IntelligentCache(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public Object get(int key) {
        CacheNode node = map.get(key);
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, Object value) {
        CacheNode existing = map.get(key);

        if (existing != null) {
            existing.value = value;
            moveToHead(existing);
            return;
        }

        if (map.size() == capacity) {
            evictLeastRecentlyUsed();
        }

        CacheNode newNode = new CacheNode(key, value);
        addNodeAtHead(newNode);
        map.put(key, newNode);
    }

    public boolean containsKey(int key) {
        return map.containsKey(key);
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }

    private void moveToHead(CacheNode node) {
        if (node == head) {
            return; 
        }
        removeNode(node);
        addNodeAtHead(node);
    }

    private void addNodeAtHead(CacheNode node) {
        node.prev = null;
        node.next = head;

        if (head != null) {
            head.prev = node;
        }
        head = node;

        if (tail == null) {
            tail = node; 
        }
    }

    private void removeNode(CacheNode node) {
        CacheNode prevNode = node.prev;
        CacheNode nextNode = node.next;

        if (prevNode != null) {
            prevNode.next = nextNode;
        } else {
            head = nextNode; 
        }

        if (nextNode != null) {
            nextNode.prev = prevNode;
        } else {
            tail = prevNode; 
        }

        node.prev = null;
        node.next = null;
    }

    private void evictLeastRecentlyUsed() {
        if (tail == null) {
            return;
        }
        map.remove(tail.key);
        removeNode(tail);
    }
}