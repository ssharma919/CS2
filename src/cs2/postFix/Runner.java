package cs2.postFix;

import java.util.Scanner;
import java.util.Stack;

public class Runner {
    public static void main(String[] args) {
        Scanner rdr = new Scanner(System.in);
        System.out.println("Enter your expression");
        String s = rdr.next();
        double d;
        double temp;
        Stack<Double> stk = new Stack();
        while (!s.equals("=")) {
            try {
                d = Double.parseDouble(s);
                stk.push(d);
            } catch (Exception e) {
                if (s.equals("+")) {
                    temp = stk.pop();
                    stk.push(stk.pop() + temp);
                }
                if (s.equals("-")) {
                    temp = stk.pop();
                    stk.push(stk.pop() - temp);
                }
                if (s.equals("*")) {
                    temp = stk.pop();
                    stk.push(stk.pop() * temp);
                }
                if (s.equals("/")) {
                    temp = stk.pop();
                    stk.push(stk.pop() / temp);
                }
            }
            s = rdr.next();
        }
        System.out.println(stk.pop());
    }
}
