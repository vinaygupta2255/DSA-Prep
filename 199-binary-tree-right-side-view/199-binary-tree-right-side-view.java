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

    //using level order traversal
    public List<Integer> rightSideView1(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        TreeMap<Integer, Integer> tMap = new TreeMap<Integer, Integer>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        int level = 0;
        while (!q.isEmpty()) {
            TreeNode peek = q.peek();
            q.remove();
            if (peek == null) {
                //purana level complete traverse ho chuka hai
                level++;
                
                //System.out.println("");// enter to next line
                if (!q.isEmpty()) {
                    //queue still has some child ndoes
                    q.add(null);
                }
            } else {
                if (!tMap.containsKey(level)) {
                    tMap.put(level, peek.val);
                }
                
                // change for right view
                if (peek.right != null) {
                    q.add(peek.right);
                }

                if (peek.left != null) {
                    q.add(peek.left);
                }
            }
        }

        Iterator it = tMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry me = (Map.Entry) it.next();
            ans.add((Integer) me.getValue());
        }
        return ans;
    }

    
    // using recursion
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        solve(root, ans, 0);
        return ans;
    }

    void solve(TreeNode root, ArrayList<Integer> ans, int level) {
        //base case
        if (root == null) 
            return;

        //we entered into a new level
        if (level == ans.size()) 
            ans.add(root.val);

        solve(root.right, ans, level + 1);
        solve(root.left, ans, level + 1);
    }
}
