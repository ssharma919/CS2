package cs2.bst;

public class BSTPart1Tester {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<Integer>();
        int[] vals = {3, 7, 2, 9, 3, 8, 6, 4, 1, 5, 9};

        System.out.println("Testing add:\n");
        for (int v: vals) {
            if (tree.add (v)) {
                System.out.println (v + " was added to the tree");
            }
            else {
                System.out.println (v + " was NOT added - already in tree");
            }
        }

        System.out.println("\nTesting contains:\n");
        vals = new int[] {3, 7, 2, 9, 8, 6, 4, 1, 5, 10};

        for (int v: vals) {
            if (tree.contains(v)) {
                System.out.println(v + " is in the tree");
            }
            else {
                System.out.println(v + " is NOT in the tree");
            }
        }

        System.out.println("\nTesting Level:\n");
        for (int v: vals) {
            System.out.println(v + " is at level " + tree.level(v));
        }

//        System.out.println("\nTesting Traversals:\n");
//        System.out.println ("in-order: " + tree.inOrderTraversal ());
//        System.out.println ("reverse: " + tree.reverseOrderTraversal ());
//        System.out.println ("pre-order: " + tree.preOrderTraversal());
//        System.out.println ("post-order: " + tree.postOrderTraversal());
//
//        System.out.println("\nTesting toString:\n");
//        System.out.println(tree);
//
    }
}



