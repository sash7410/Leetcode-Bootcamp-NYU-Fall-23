??https://leetcode.com/problems/container-with-most-water/description/

public class Solution {
    public int maxArea(int[] height) {
        int res = 0;
        int l = 0, r = height.length - 1;

        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            res = Math.max(res, area);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int result = sol.maxArea(height);
        System.out.println("Maximum area is: " + result);
    }
}
