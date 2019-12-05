package cs2.hash;

import java.io.File;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HashMapTester {
    public static void main(String[] args) {
        CS2HashMap<Character, String> map = new CS2HashMap(20);
        try {
            Scanner sc = new Scanner(new File("MorseCode.txt"));
            while (sc.hasNext()) {
                String str = sc.nextLine();
                map.put(str.charAt(0), str.substring(2));

            }
            sc.close();
        }
        catch (Exception e) {
            throw new NullPointerException();
        }

        System.out.println(map);
        while (true) {
            try {
                Scanner s = new Scanner(System.in);
                System.out.println("Enter the phrase you would like to translate: ");
                String result = "";
                String str = s.nextLine();
                str = str.toUpperCase();
                char[] arr = str.toCharArray();
                for (Character c : arr) {
                    if (c == ' ') result += "  ";
                    else if (map.get(c) == null) throw new NullPointerException("Character is not available");
                    else result += map.get(c) + " ";
                }
                System.out.println(result);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
}
