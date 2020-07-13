// https://leetcode.com/problems/range-sum-of-bst/

/**
 * 
 * Given the root node of a binary search tree, return the sum of values of all nodes with value between L and R (inclusive).

The binary search tree is guaranteed to have unique values.

 

Example 1:

Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
Output: 32
Example 2:

Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
Output: 23
 

Note:

The number of nodes in the tree is at most 10000.
The final answer is guaranteed to be less than 2^31.
*/
 // Definition for a binary tree node.

import java.util.*;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {}
      TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
       this.val = val;
          this.left = left;
          this.right = right;
     }
 }
 
public class Solution_938 {
    private int rangeSum;
    public int rangeSumBST(TreeNode root, int L, int R) {
        rangeSum = 0;
        getRangeSum(root, L, R);
        return rangeSum;
    }
    
    public void getRangeSum(TreeNode root, int L, int R){
        if(root != null){
            if(root.val >= L && root.val <= R){
                rangeSum += root.val;
            }
            if(root.val > L) getRangeSum(root.left, L, R);
            if(root.val < R) getRangeSum(root.right, L, R);
        }
    }
    
      public int rangeSumBSTInterative(TreeNode root, int L, int R) {
        int rangeSum = 0;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            
            if(node.val>= L && node.val <= R )  rangeSum += node.val;
            if(node.val > L && node.left != null) stack.push(node.left);
            if(node.val < R && node.right != null) stack.push(node.right);
        }
        return rangeSum;
    }
}