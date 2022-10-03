/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        List<Integer> path = new ArrayList<Integer>();
        if (root == null) {
            return ans;
        }
        solve(root, targetSum, path, ans);
        return ans;
    }

    void solve(TreeNode root, int targetSum, List<Integer> path, List<List<Integer>> ans) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        
        int pathSum = 0;
        if (root.left == null && root.right == null) {
            for (int i = 0; i < path.size(); i++) {
                pathSum += path.get(i);
            }
            if (pathSum == targetSum) {
                List<Integer> tempPath = new ArrayList<Integer>();
                tempPath.addAll(path);
                ans.add(tempPath);
            }
            return;
        }

        solve(root.left, targetSum, path, ans);
        if (root.left != null) path.remove(path.size() - 1);

        solve(root.right, targetSum, path, ans);
        if (root.right != null) path.remove(path.size() - 1);
        return;
    }
}
