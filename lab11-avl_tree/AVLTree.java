// TODO: Implement the AVLNode class
class AVLNode {
    int key, height;
    AVLNode left, right;

    // Constructor
    AVLNode(int key) {
        // TODO: Initialize key, height, left, and right
        this.key = key;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

public class AVLTree {

    AVLNode root;

    // TODO: Return height of a node
    int height(AVLNode N) {
        return (N == null) ? 0 : N.height; // placeholder
    }

    // TODO: Return maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b; // placeholder
    }

    // TODO: Compute balance factor
    int getBalance(AVLNode N) {
        if (N == null) {
            return 0; // placeholder
        }
        return height(N.left) - height(N.right); // placeholder
    }

    // TODO: Right rotation
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        return x; // placeholder
    }

    // TODO: Left rotation
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        return y; // placeholder
    }

    // TODO: Left-Right rotation
    AVLNode leftRightRotate(AVLNode z) {
        z.left = leftRotate(z.left);
        return rightRotate(z); // placeholder
    }

    // TODO: Right-Left rotation
    AVLNode rightLeftRotate(AVLNode y) {
        y.right = rightRotate(y.right);
        return leftRotate(y); // placeholder
    }

    // Public insert method
    public void insert(int key) {
        root = insert(root, key);
    }

    // TODO: Recursive insertion with rebalancing
    private AVLNode insert(AVLNode node, int key) {
        if (node == null) {
            return new AVLNode(key); // placeholder
        }

        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        } else {
            return node; // placeholder
        }

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key) {
            return rightRotate(node);
        }

        if (balance < -1 && key > node.right.key) {
            return leftRotate(node);
        }

        if (balance > 1 && key > node.left.key) {
            return leftRightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            return rightLeftRotate(node);
        }

        return node; // placeholder
    }

    // TODO: Traversal methods
    public void inorder() {
        inorder(root);
        System.out.println();
    }

    private void inorder(AVLNode node) {
        if (node == null) {
            return; // placeholder
        }
        inorder(node.left);
        System.out.print(node.key + " ");
        inorder(node.right);
    }

    public void preorder() {
        preorder(root);
        System.out.println();
    }

    private void preorder(AVLNode node) {
        if (node == null) {
            return; // placeholder
        }
        System.out.print(node.key + " ");
        preorder(node.left);
        preorder(node.right);
    }

    public void postorder() {
        postorder(root);
        System.out.println();
    }

    private void postorder(AVLNode node) {
        if (node == null) {
            return; // placeholder
        }
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.key + " ");
    }
}
