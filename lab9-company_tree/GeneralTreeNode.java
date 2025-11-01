import java.util.ArrayList;
import java.util.List;

public class GeneralTreeNode {
    String name; // Employee name or department title
    GeneralTreeNode parent;
    List children;

    public GeneralTreeNode(String name) {
        this.name = name;
        this.parent = null;
        this.children = new ArrayList<>();
    }

    // Method to add a child to this node
    public void addChild(GeneralTreeNode child) {
        child.parent = this;
        this.children.add(child);
    }

    // --- TO BE COMPLETED BY STUDENT ---

    /**
     * Performs a preorder traversal starting from this node.
     * Prints the name of each node visited.
     * (Visit Parent, then visit children)
     */
    public void traversePreorder() {
        // Your code here
        // 1. Print this node's name
        // 2. Recursively call traversePreorder on each child
        System.out.println(this.name);
        for (int i = 0; i < this.children.size(); i++) {
            GeneralTreeNode child = (GeneralTreeNode) this.children.get(i);
            child.traversePreorder();
        }
    }

    /**
     * Performs a postorder traversal starting from this node.
     * Prints the name of each node visited.
     * (Visit children, then visit Parent)
     */
    public void traversePostorder() {
        // Your code here
        // 1. Recursively call traversePostorder on each child
        // 2. Print this node's name
        for (int i = 0; i < this.children.size(); i++) {
            GeneralTreeNode child = (GeneralTreeNode) this.children.get(i);
            child.traversePostorder();
        }
        System.out.println(this.name);
    }
}
