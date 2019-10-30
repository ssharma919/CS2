package cs2.queue;

public class QTest {
    public static void main(String[] args) {
        CS2Queue<String> q = new CS2Queue<String>();

        q.add ("A");    System.out.println (q);         // A
        q.add ("B");    System.out.println (q);         // A, B
        q.add ("C");    System.out.println (q);         // A, B, C
        System.out.println( q.peek());                  // A
        System.out.println (q.remove());                // A
        System.out.println (q);                         // B, C
        q.add ("D");    System.out.println (q);         // B, C, D
        System.out.println (q.remove());                // B
        System.out.println (q);                         // C, D
        System.out.println (q.remove());                // C
        System.out.println (q);                         // D
        System.out.println (q.remove());                // D
        System.out.println (q);                         // Empty
        System.out.println(q.peek());                  // null
    }
}

