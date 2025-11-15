import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// Simplified node structure
class TwoFourNode {
    List<Integer> keys;
    List<TwoFourNode> children;
    TwoFourNode parent;

    public TwoFourNode() {
        keys = new ArrayList<>();
        children = new ArrayList<>();
        parent = null;
    }

    public boolean isLeaf() {
        return children.isEmpty();
    }

    // Check if node is full (3 keys)
    public boolean isFull() {
        return keys.size() == 3;
    }

    // Find correct child to descend for a given key
    public TwoFourNode getNextChild(int key) {
        // TODO: Implement traversal logic
        int i = 0;
        while (i < keys.size() && key > keys.get(i)) {
            i++;
        }
        return children.get(i);
    }

    // Insert a key into this node (assume node not full)
    public void insertKey(int key) {
        // TODO: Add key and sort
        keys.add(key);
        Collections.sort(keys);
    }
}

public class TwoFourTree {

    private TwoFourNode root;

    public TwoFourTree() {
        root = new TwoFourNode();
    }

    public void insert(int key) {
        TwoFourNode node = root;

        // 1. Descend to the leaf node
        while (!node.isLeaf()) {
            node = node.getNextChild(key);
        }

        // 2. Insert key in leaf
        node.insertKey(key);

        // 3. Handle overflow by splitting
        while (node != null && node.keys.size() > 3) {
            split(node);
            node = node.parent;
        }
    }

    private void split(TwoFourNode node) {
        // TODO: Implement split logic
        // 1. Create a new right node
        // 2. Promote middle key to parent
        // 3. Move keys and children appropriately
        // 4. Update parent pointers
        System.out.println("Splitting node with keys: " + node.keys);

        int midIndex = 1;
        int midKey = node.keys.get(midIndex);

        TwoFourNode left = new TwoFourNode();
        TwoFourNode right = new TwoFourNode();

        for (int i = 0; i < midIndex; i++) {
            left.keys.add(node.keys.get(i));
        }
        for (int i = midIndex + 1; i < node.keys.size(); i++) {
            right.keys.add(node.keys.get(i));
        }

        if (!node.children.isEmpty()) {
            for (int i = 0; i <= midIndex; i++) {
                TwoFourNode child = node.children.get(i);
                left.children.add(child);
                child.parent = left;
            }
            for (int i = midIndex + 1; i < node.children.size(); i++) {
                TwoFourNode child = node.children.get(i);
                right.children.add(child);
                child.parent = right;
            }
        }

        TwoFourNode parent = node.parent;

        if (parent == null) {
            parent = new TwoFourNode();
            root = parent;
        }

        left.parent = parent;
        right.parent = parent;

        if (parent.children.isEmpty()) {
            parent.keys.add(midKey);
            parent.children.add(left);
            parent.children.add(right);
        } else {
            int index = parent.children.indexOf(node);
            parent.children.remove(index);

            parent.keys.add(index, midKey);
            parent.children.add(index, left);
            parent.children.add(index + 1, right);
        }
    }

    // Inorder traversal
    public void inorder() {
        System.out.print("Inorder: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(TwoFourNode node) {
        if (node == null) return;

        if (node.isLeaf()) {
            for (int key : node.keys) {
                System.out.print(key + " ");
            }
        } else {
            int i;
            for (i = 0; i < node.keys.size(); i++) {
                if (i < node.children.size()) {
                    inorder(node.children.get(i));
                }
                System.out.print(node.keys.get(i) + " ");
            }
            if (i < node.children.size()) {
                inorder(node.children.get(i));
            }
        }
    }
}
