package cs2.bst2;

import java.util.LinkedList;
import java.util.List;

public class BST <E extends Comparable<E>> {

    private TreeNode root;
    private int size = 0;

    public boolean add (E value) {
        if (root == null) {
            root = new TreeNode (value);
            size++;
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
                size++;
                return true;
            } else return add(subRoot.getLeft(), node);
        } else if (node.compareTo(subRoot) > 0) {
            if (subRoot.getRight() == null) {
                subRoot.setRight(node);
                node.setParent(subRoot);
                size++;
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

    public List<E> inOrderTraversal() {
        List<E> list = new LinkedList<E>();
        inOrderTraversal (root, list);
        return list;
    }

    private void inOrderTraversal(TreeNode subRoot, List<E> list) {
        if (subRoot.getLeft() != null) inOrderTraversal(subRoot.getLeft(), list);
        list.add(subRoot.getValue());
        if (subRoot.getRight() != null) inOrderTraversal(subRoot.getRight(), list);
    }

    public List<E> reverseOrderTraversal() {
        List<E> list = new LinkedList<E>();
        reverseOrderTraversal (root, list);
        return list;
    }

    private void reverseOrderTraversal(TreeNode subRoot, List<E> list) {
        if (subRoot.getRight() != null) reverseOrderTraversal(subRoot.getRight(), list);
        list.add(subRoot.getValue());
        if (subRoot.getLeft() != null) reverseOrderTraversal(subRoot.getLeft(), list);
    }

    public List<E> preOrderTraversal() {
        List<E> list = new LinkedList<E>();
        preOrderTraversal (root, list);
        return list;
    }

    private void preOrderTraversal(TreeNode subRoot, List<E> list) {
        list.add(subRoot.getValue());
        if (subRoot.getLeft() != null) preOrderTraversal(subRoot.getLeft(), list);
        if (subRoot.getRight() != null) preOrderTraversal(subRoot.getRight(), list);
    }

    public List<E> postOrderTraversal() {
        List<E> list = new LinkedList<E>();
        postOrderTraversal (root, list);
        return list;
    }

    private void postOrderTraversal(TreeNode subRoot, List<E> list) {
        if (subRoot.getLeft() != null) postOrderTraversal(subRoot.getLeft(), list);
        if (subRoot.getRight() != null) postOrderTraversal(subRoot.getRight(), list);
        list.add(subRoot.getValue());
    }

    public String toString() {
        return toString(root, 0);
    }

    private String toString(TreeNode subRoot, int level) {
        if (subRoot == null) return "";
        String s = toString(subRoot.getRight(), level + 1);
        for (int i = 0; i < level; i++) s += "- ";
        s = s + subRoot.getValue() + "\n";
        s += toString(subRoot.getLeft(), level + 1);
        return s;
    }

    public void clear() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean remove(E obj) {
        return remove(new TreeNode(obj));
    }

    private boolean remove(TreeNode subRoot) {
        if (!contains(root, subRoot)) return false;

        // leaf case
        if (subRoot.getLeft() == null && subRoot.getRight() == null) {

            // root case
            if (subRoot.equals(root)) {
                clear();
                return true;
            }

            // left case
            else if (subRoot.compareTo(subRoot.getParent()) < 0) {
                subRoot.getParent().setLeft(null);
                return true;
            }

            // right case
            else {
                subRoot.getParent().setRight(null);
                return true;
            }
        }

        // one-child case
        else if ((subRoot.getRight() != null && subRoot.getLeft() == null) || (subRoot.getRight() == null && subRoot.getLeft() != null)) {

            // root case
            if (subRoot.equals(root)) {
                if (root.getLeft() != null) {
                    root = root.getLeft();
                    return true;
                } else {
                    root = root.getRight();
                    return true;
                }
            }

            // parent left
            else if (subRoot.compareTo(subRoot.getParent()) < 0) {

                // child left case
                if (subRoot.getLeft() != null) {
                    subRoot.getParent().setLeft(subRoot.getLeft());
                    subRoot.getLeft().setParent(subRoot.getParent());
                    return true;
                }

                // child right case
                else {
                    subRoot.getParent().setLeft(subRoot.getRight());
                    subRoot.getRight().setParent(subRoot.getParent());
                    return true;
                }
            }

            // parent right
            else {

                // child left case
                if (subRoot.getLeft() != null) {
                    subRoot.getParent().setRight(subRoot.getLeft());
                    subRoot.getLeft().setParent(subRoot.getParent());
                    return true;
                }

                // child right case
                else {
                    subRoot.getParent().setRight(subRoot.getRight());
                    subRoot.getRight().setParent(subRoot.getParent());
                    return true;
                }
            }
        }

        // two-child case
        else {

            // root case
            if (subRoot.equals(root)) {
                TreeNode temp = root.getRight();
                root = root.getLeft();
                root.setRight(temp);
            }
        }
        return false;
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


