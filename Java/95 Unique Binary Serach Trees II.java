/*
Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1 ... n.

Example:

Input: 3
Output:
[
  [1,null,3,2],
  [3,2,null,1],
  [3,1,null,null,2],
  [2,1,3],
  [1,null,2,null,3]
]
Explanation:
The above output corresponds to the 5 unique BST's shown below:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   */
   
   --Approach: given a sequence 1...n to construct a BST out of the sequencem, we could enumerate each number i in the sequence, and use the number as the root, 
   naturally, the subsequence 1...(i-1) on its left side would lay on the left branch of the root, and similarly the right subsequence (i+1)...n lay on the right
   side of the branch of the root. We can construct the subtree from the subsequence recursively. Through the above approach, we could ensure that the BST we constrcut
   are all unique, since they have unique roots.
   --Pay attention! The print approach of the main() method of this question in Leetcode is in-first traverse order, and each element of the list you need to add is the
   root of the tree.
     
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
    public List<TreeNode> generateTrees(int n) {
        if(n==0) return new ArrayList<>();
        return genTree(1,n);
    }
    private List<TreeNode> genTree(int start, int end){
        List<TreeNode> treeList=new ArrayList<TreeNode>();
        if(start>end)
            treeList.add(null);
        for(int i=start;i<=end;i++){
            List<TreeNode> leftTree=genTree(start,i-1);
            List<TreeNode> rightTree=genTree(i+1,end);
            for(TreeNode leftNode:leftTree){
                for(TreeNode rightNode:rightTree){
                    TreeNode root=new TreeNode(i);
                    root.left=leftNode;
                    root.right=rightNode;
                    treeList.add(root);
                }
            }
        }
        return treeList;
    }
}
