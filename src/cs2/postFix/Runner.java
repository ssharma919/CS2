package cs2.postFix;

import cs2.stack.CS2Stack;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner rdr = new Scanner(System.in);
        System.out.println("Enter your expression");
        String s = rdr.next();
        double d;
        double temp;
        CS2Stack<Double> stk = new CS2Stack();
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
