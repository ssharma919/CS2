package cs2.bst;

import sun.reflect.generics.tree.Tree;

public class BST <E extends Comparable<E>> {

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

        @Override
        public int compareTo(TreeNode o) {
            return 0;
        }
    }
}


