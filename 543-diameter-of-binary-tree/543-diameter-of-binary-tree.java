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
    
    /* diameter with O(n) complexity */
    public int diameterOfBinaryTree(TreeNode root) {
        return diameterFast(root)[0]-1;
    }
    
	private int[] diameterFast(TreeNode root) {
		if(root == null) {
			int[] p = new int[]{0,0};
			return p;
		}

		int[] left = diameterFast(root.left);
		int[] right = diameterFast(root.right);

		int op1 = left[0]; // extracting diameter
		int op2 = right[0]; // extracting diameter
		int op3 = left[1] + right[1] + 1; // extracting height

		int[] answer = new int[2];
		answer[0] = Math.max(op1, Math.max(op2, op3));
		answer[1] = Math.max(left[1], right[1]) + 1;
		return answer;
	}
    
    public int height(TreeNode root) {
		if(root == null)
			return 0;
		int leftHeight = height(root.left);
		int rightHeight = height(root.right);
        
		return Math.max(leftHeight, rightHeight) +1 ;
	}
	

	/* diameter with O(n2) complexity */
	public int diameterOfBT(TreeNode root) {
		if(root == null) {
			return 0;
		}
		int op1 = diameterOfBT(root.left);
		int op2 = diameterOfBT(root.right);
		int op3 = height(root.left) + 1 + height(root.right);
		return Math.max(op1, Math.max(op2, op3)) -1;
	}
    
}