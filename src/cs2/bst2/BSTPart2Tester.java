package cs2.bst2;

public class BSTPart2Tester {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<Integer>();
        int[] vals = {3, 7, 2, 9, 3, 8, 6, 4, 1, 5, 9};

        System.out.println("Creating Tree:\n");
        for (int v: vals) tree.add(v);
        System.out.println(tree);

        System.out.println("\nTesting clear/size:\n");
        tree.clear();
        System.out.println("Cleared Tree:");
        System.out.println ("Size is: " + tree.size());
        System.out.println (tree);

        System.out.println("Building new tree...");
        vals = new int[] {2, 1, 7, 4, 9, 3, 6, 8, 5};
        for (int i: vals) tree.add (i);
        System.out.println ("Size is: " + tree.size());
        System.out.println (tree);

        // removals
        System.out.println("Testing removes/size: ");
        System.out.print("Removed leaf node (8): ");
        System.out.println(tree.remove(8));
        System.out.println ("Size is: " + tree.size());
        System.out.println (tree);

        System.out.println("Restoring tree...");
        tree.clear();
        for (int i: vals) tree.add (i);

        System.out.print("Removed one-child node (6): ");
        System.out.println(tree.remove(6));
        System.out.println ("Size is: " + tree.size());
        System.out.println (tree);

        System.out.println("Restoring tree...");
        tree.clear();
        for (int i: vals) tree.add (i);

        System.out.print("Removed two-child node (4): ");
        System.out.println(tree.remove(4));
        System.out.println ("Size is: " + tree.size());
        System.out.println (tree);

        System.out.println("Restoring tree...");
        tree.clear();
        for (int i: vals) tree.add (i);

        System.out.print("Removed 2-child root (2): ");
        System.out.println(tree.remove(2));
        System.out.println ("Size is: " + tree.size());
        System.out.println (tree);

        System.out.print("Removed 1-child root (1): ");
        System.out.println(tree.remove(1));
        System.out.println ("Size is: " + tree.size());
        System.out.println (tree);

        System.out.print("Removed (1) again: ");
        System.out.println(tree.remove(1));
        System.out.println ("Size is: " + tree.size());
        System.out.println (tree);

        System.out.println("Remove remaining values");
        for (int i=3; i<=9; i++) {
            System.out.println("Remove " + i + ": " + tree.remove(i));
            System.out.println("Size is: " + tree.size());
            System.out.println(tree);
        }

//        System.out.println("\nRestoring tree...");
//        tree.clear();
//        for (int i: vals) tree.add (i);
//        System.out.println(tree);
//
//        System.out.println("Testing iterator with enhanced-for");
//        for (Integer i: tree) {
//            System.out.print(i+ " ");
//        }
    }
}