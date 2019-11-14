package cs2.heap;

public class HeapTester {
    public static void main (String argv[]) {
        Heap<Integer> h = new Heap<Integer>();
        h.add (12);
        h.add (20);
        h.add (25);
        h.add (50);
        h.add (75);
        h.add (90);
        System.out.println (h);
        h.clear ();
        System.out.println (h);
        System.out.println();

        h.add (90);
        h.add (75);
        h.add (50);
        h.add (25);
        h.add (20);
        h.add (12);
        System.out.println (h);

        while (!h.isEmpty()) {
            System.out.print(h.remove() + " ");
        }

    }
}
