import java.util.HashMap;

public class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int m = s.length();
        int need = tMap.size();
        int have = 0;
        int left = 0;
        int right;
        String minStr = "";
        int minLength = Integer.MAX_VALUE;
        HashMap<Character, Integer> sMap = new HashMap<>();

        for (right = 0; right < m; right++) {
            char currentChar = s.charAt(right);
            sMap.put(currentChar, sMap.getOrDefault(currentChar, 0) + 1);

            if (tMap.containsKey(currentChar) && sMap.get(currentChar).equals(tMap.get(currentChar))) {
                have++;
            }

            while (have == need && left <= right) {
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minStr = s.substring(left, right + 1);
                }
                char leftChar = s.charAt(left);
                if (tMap.containsKey(leftChar) && sMap.get(leftChar).equals(tMap.get(leftChar))) {
                    have--;
                }
                sMap.put(leftChar, sMap.get(leftChar) - 1);
                left++;
            }
        }

        return minStr;
    }
}
