class Solution {
    int i = 1; //this will track the position of the element
    int ans = 0; //this wil store the answer

    public int kthSmallest(TreeNode root, int k) {
        //We will pick kth element while doing Inorder traversal,
        solve(root, k);
        return ans;
    }

    public void solve(TreeNode root, int k) {
        if (root == null) return;

        solve(root.left, k);

        if (i == k) ans = root.val;
        i++;

        solve(root.right, k);
    }
}
