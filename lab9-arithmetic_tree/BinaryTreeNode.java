public class BinaryTreeNode {
    String value; // Can be an operator "+" or an operand "3"
    BinaryTreeNode parent;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(String value) {
        this.value = value;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    // --- TO BE COMPLETED BY STUDENT ---

    /**
     * Performs a preorder traversal starting from this node.
     * (Visit Parent, then Left, then Right)
     * This should output Prefix notation.
     */
    public void traversePreorder() {
        // Your code here
        // 1. Print this node's value
        // 2. Recursively call on left child (if not null)
        // 3. Recursively call on right child (if not null)
        System.out.print(this.value + " ");
        if (this.left != null) this.left.traversePreorder();
        if (this.right != null) this.right.traversePreorder();
    }

    /**
     * Performs an inorder traversal starting from this node.
     * (Visit Left, then Parent, then Right)
     * This should output Infix notation (you can add parentheses for clarity).
     */
    public void traverseInorder() {
        // Your code here
        // (Optional: Print "(" before recursing left)
        // 1. Recursively call on left child (if not null)
        // 2. Print this node's value
        // 3. Recursively call on right child (if not null)
        // (Optional: Print ")" after recursing right)
        if (this.left != null) {
            System.out.print("(");
            this.left.traverseInorder();
        }
        System.out.print(this.value);
        if (this.right != null) {
            this.right.traverseInorder();
            System.out.print(")");
        }
    }

    /**
     * Performs a postorder traversal starting from this node.
     * (Visit Left, then Right, then Parent)
     * This should output Postfix (RPN) notation.
     */
    public void traversePostorder() {
        // Your code here
        // 1. Recursively call on left child (if not null)
        // 2. Recursively call on right child (if not null)
        // 3. Print this node's value
        if (this.left != null) this.left.traversePostorder();
        if (this.right != null) this.right.traversePostorder();
        System.out.print(this.value + " ");
    }
}
