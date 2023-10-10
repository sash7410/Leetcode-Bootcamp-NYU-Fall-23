https://leetcode.com/problems/sliding-window-maximum/

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> output = new ArrayList<>();
        int l = 0, r = 0;
        LinkedList<Integer> q = new LinkedList<>();

        while (r < nums.length) {
            while (!q.isEmpty() && nums[q.getLast()] < nums[r]) {
                q.removeLast();
            }
            q.addLast(r);

            if (l > q.getFirst()) {
                q.removeFirst();
            }

            if ((r + 1) >= k) {
                output.add(nums[q.getFirst()]);
                l++;
            }
            r++;
        }

        int[] resultArray = new int[output.size()];
        for (int i = 0; i < output.size(); i++) {
            resultArray[i] = output.get(i);
        }

        return resultArray;
    }
}
