/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		// base casees
		if(root == null)
			return null;

		if(root.val == p.val ||  root.val == q.val) {
			return root;
		}


		TreeNode leftAns = lowestCommonAncestor(root.left, p, q);
		TreeNode rightAns = lowestCommonAncestor(root.right, p, q);

		if(leftAns!=null && rightAns!=null) {
			return root;
		}
		else if(leftAns!=null && rightAns==null) {
			return leftAns;
		}else if(leftAns==null && rightAns!=null) {
			return rightAns;
		}else {
			return null;
		}
	
	}
}