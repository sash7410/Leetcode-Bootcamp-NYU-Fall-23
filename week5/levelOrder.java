import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) { this.val = val; }
}

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }

        Deque<TreeNode> Q = new LinkedList<>();
        Q.offer(root);

        List<List<Integer>> levels = new ArrayList<>();
        levels.add(new ArrayList<>());
        levels.get(0).add(root.val);

        Deque<TreeNode> temp = new LinkedList<>();

        while (!Q.isEmpty()) {
            TreeNode node = Q.poll();
            if (node.left != null) {
                temp.offer(node.left);
            }
            if (node.right != null) {
                temp.offer(node.right);
            }

            if (Q.isEmpty()) {
                if (!temp.isEmpty()) {
                    List<Integer> level = new ArrayList<>();
                    for (TreeNode n : temp) {
                        level.add(n.val);
                    }
                    levels.add(level);
                }
                Q = temp;
                temp = new LinkedList<>();
            }
        }

        return levels;
    }
}
