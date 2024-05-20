package HW8;

import java.util.HashMap;

public class longPal {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        int len = 0;
        boolean oddF = false;
        

        for (int x : freq.values()) {
            if (x % 2 == 0) {


                len += x;
            } else {
                len += x - 1;

                oddF = true;
            }
        }
        if (oddF) {
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        longPal lp = new longPal();
        String s = "abccccdd"; 
        String s1 = "speediskey";

        System.out.println(lp.longestPalindrome(s1));
        System.out.println(lp.longestPalindrome(s)); 
    }
}
