import java.util.HashMap;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int maxLen = 0;

        for (int r = 0; r < s.length(); r++) {
            char currentChar = s.charAt(r);

            if (hashMap.containsKey(currentChar)) {
                // Update the left pointer if the new position is greater
                l = Math.max(hashMap.get(currentChar) + 1, l);
            }

            hashMap.put(currentChar, r);
            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
