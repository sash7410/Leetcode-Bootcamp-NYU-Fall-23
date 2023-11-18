import java.util.HashMap;
import java.util.ArrayList;

public class Solution {
    public int shortestSubarray(int[] nums, int k) {
        HashMap<Integer, Integer> loc = new HashMap<>();
        loc.put(0, -1);
        ArrayList<Integer> stack = new ArrayList<>();
        stack.add(0);

        int ans = Integer.MAX_VALUE;
        int prefix = 0;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];

            // Find the rightmost value less than or equal to prefix - k
            int ii = findRightmost(stack, loc, prefix - k);
            if (ii != -1) {
                ans = Math.min(ans, i - loc.get(stack.get(ii)));
            }

            loc.put(prefix, i);
            while (!stack.isEmpty() && stack.get(stack.size() - 1) >= prefix) {
                stack.remove(stack.size() - 1);
            }
            stack.add(prefix);
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int findRightmost(ArrayList<Integer> stack, HashMap<Integer, Integer> loc, int target) {
        // Binary search to find the rightmost value less than or equal to target
        int low = 0, high = stack.size() - 1;
        while (low < high) {
            int mid = (low + high + 1) / 2;
            if (loc.get(stack.get(mid)) <= target) {
                low = mid;
            } else {
                high = mid - 1;
            }
        }
        return loc.get(stack.get(low)) <= target ? low : -1;
    }
}
