package cs2.morsecode;

import java.io.File;
import java.util.Scanner;

public class MorseCodeRunner2 {
    public static void main(String[] args) {
        String[] arrS = new String[256];
        try {
            Scanner sc = new Scanner(new File("MorseCode.txt"));
            while (sc.hasNext()) {
                String str = sc.nextLine();
                int index = (int)str.charAt(0);
                arrS[index] = str.substring(2);
            }
            sc.close();
        } catch (Exception e) {
            throw new NullPointerException();
        }
        do {
            try {
                Scanner s = new Scanner(System.in);
                System.out.println("Enter the phrase you would like to translate: ");
                String result = "";
                String str = s.nextLine();
                str = str.toUpperCase();
                char[] arr = str.toCharArray();
                for (Character c : arr) {
                    if (c == ' ') result += "  ";
                    else if (arrS[(int)c] == null) throw new NullPointerException("Character is not available");
                    else result += arrS[(int)c] + " ";
                }
                System.out.println(result);
            } catch (Exception e) {
                System.out.println(e);
            }
        } while (true);
    }
}
