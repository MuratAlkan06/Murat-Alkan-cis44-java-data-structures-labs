import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

// --- Heap Implementation ---
class HeapPriorityQueue<K extends Comparable<K>> {
    private ArrayList<K> heap = new ArrayList<>();

    // Helper methods
    protected int parent(int j) { return (j - 1) / 2; }
    protected int left(int j) { return 2 * j + 1; }
    protected int right(int j) { return 2 * j + 2; }

    public int size() { return heap.size(); }
    public boolean isEmpty() { return heap.isEmpty(); }
    
    private void swap(int i, int j) {
        K temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(K key) {
        heap.add(key);
        upheap(heap.size() - 1);
    }

    public K removeMin() {
        if (isEmpty()) return null;
        K answer = heap.get(0);
        // Move last element to root
        K last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            downheap(0);
        }
        return answer;
    }

    public K min() {
        return isEmpty() ? null : heap.get(0);
    }

    private void upheap(int j) {
        // TODO: While j > 0 and parent > child, swap and move up
        while (j > 0) {
            int p = parent(j);
            if (heap.get(p).compareTo(heap.get(j)) <= 0) {
                break;
            }
            swap(p, j);
            j = p;
        }
    }

    private void downheap(int j) {
        // TODO: While j has left child...
        // Find smaller child, swap if child < parent, move down
        int n = heap.size();
        while (left(j) < n) {
            int leftIndex = left(j);
            int smallChildIndex = leftIndex;
            int rightIndex = right(j);
            if (rightIndex < n && heap.get(rightIndex).compareTo(heap.get(leftIndex)) < 0) {
                smallChildIndex = rightIndex;
            }
            if (heap.get(smallChildIndex).compareTo(heap.get(j)) >= 0) {
                break;
            }
            swap(j, smallChildIndex);
            j = smallChildIndex;
        }
    }
}
