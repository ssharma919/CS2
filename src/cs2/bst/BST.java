package cs2.bst;

import sun.reflect.generics.tree.Tree;

public class BST <E extends Comparable<E>> {

    private TreeNode root;

    public boolean add (E value) {
        if (root == null) {
            root = new TreeNode (value);
            return true;
        } else {
            return add (root, new TreeNode(value));
        }
    }

    private boolean add (TreeNode subRoot, TreeNode node) {
        if (node.compareTo(subRoot) < 0) {
            if (subRoot.getLeft() == null) {
                subRoot.setLeft(node);
                node.setParent(subRoot);
                return true;
            } else return add(subRoot.getLeft(), node);
        } else if (node.compareTo(subRoot) > 0) {
            if (subRoot.getRight() == null) {
                subRoot.setRight(node);
                node.setParent(subRoot);
                return true;
            } else return add(subRoot.getRight(), node);
        } else return false;
    }

    public boolean contains (E value) {
        if (root == null) {
            return false;
        }
        else {
            return contains (root, new TreeNode(value));
        }

    }

    private boolean contains (TreeNode subRoot, TreeNode node) {
        if (subRoot.equals(node))
            return true;
        else if (node.compareTo(subRoot) < 0) {
            if (subRoot.getLeft() == null) return false;
            else return contains(subRoot.getLeft(), node);
        } else if (node.compareTo(subRoot) > 0) {
            if (subRoot.getRight() == null) return false;
            else return contains(subRoot.getRight(), node);
        } else return false;
    }

    public int level (E value) {
        if (root == null) {
            return -1;
        }
        else {
            return level (root, new TreeNode(value), 0);
        }
    }

    private int level (TreeNode subRoot, TreeNode node, int level) {
        if (subRoot.equals(node)) {
            return level;
        } else if (node.compareTo(subRoot) < 0) {
            if (subRoot.getLeft() != null)
                return level(subRoot.getLeft(), node, level+1);
            else return -1;
        } else if (node.compareTo(subRoot) > 0) {
            if (subRoot.getRight() != null)
                return level(subRoot.getRight(), node, level+1);
            else return -1;
        } else return -1;
    }

    private class TreeNode implements Comparable<TreeNode> {

        private E value;
        private TreeNode left;
        private TreeNode right;
        private TreeNode parent;

        public TreeNode(E val) {
            value = val;
            left = null;
            right = null;
            parent = null;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }

        public TreeNode getParent() {
            return parent;
        }

        public void setParent(TreeNode parent) {
            this.parent = parent;
        }

        public boolean equals(TreeNode other) {
            return (this.getValue().equals(other.getValue()));
        }

        public int compareTo(TreeNode other) {
            return this.getValue().compareTo(other.getValue());
        }

        public String toString() {
            return ("" + this.getValue());
        }
    }
}


