import java.util.HashMap;

public class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        HashMap<Character, Character> sToT = new HashMap<>();
        HashMap<Character, Character> tToS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            if (sToT.containsKey(sChar)) {
                if (sToT.get(sChar) != tChar) {
                    return false;
                }
            } else {
                if (tToS.containsKey(tChar)) {
                    return false;
                }
                sToT.put(sChar, tChar);
                tToS.put(tChar, sChar);
            }
        }

        return true;
    }
}
