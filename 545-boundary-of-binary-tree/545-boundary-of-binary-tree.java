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
    
    
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        
        if(root == null) // blank root case
            return list;
        list.add(root.val);
        
        if(root.left == null && root.right == null) // single element case
           return list;
        
        leftBoundary(root.left, list);
        leafNodes(root, list);
        rightBoundary(root.right, list);
        return list;
        
    }
    
     public void leftBoundary(TreeNode root, List<Integer> list) {
        
        if(root == null || (root.left==null && root.right==null))
            return;

           list.add(root.val);
           
           if(root.left !=null)
               leftBoundary(root.left, list);
           else
               leftBoundary(root.right, list);
        
       }
          
           
     public void rightBoundary(TreeNode root, List<Integer> list) {
            
        if(root == null || (root.left==null && root.right==null))
            return;

           if(root.right !=null)
               rightBoundary(root.right, list);
           else
               rightBoundary(root.left, list);

           list.add(root.val);// adding in reverse order using Head Recursion
           
         }
           
           public void leafNodes(TreeNode root, List<Integer> list){
               
               //inorder traversal
               if(root == null)
                    return;
               
               leafNodes(root.left, list);
               if(root.left == null && root.right == null){
                 list.add(root.val);  
               }
               leafNodes(root.right, list);
           }
           
           
    }