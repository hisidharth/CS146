package Lab2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class anagram {
    
    public boolean ana(String s, String t){

        List<Character> sArray = new ArrayList<>();
        List<Character> tArray = new ArrayList<>();

        if (s.length() != t.length()) {
            return false;

        }


        for(int x = 0; x< s.length(); x++){

            sArray.add(s.charAt(x));

        }
        for(int x = 0; x< t.length(); x++){

            tArray.add(t.charAt(x));

        }
        Collections.sort(sArray);
        Collections.sort(tArray);
        for (int i = 0; i < sArray.size(); i++) {
            if (!sArray.get(i).equals(tArray.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        anagram test = new anagram();
        System.out.println(test.ana("oll", "lol"));

    }
        
}
