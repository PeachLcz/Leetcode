/*
Given a binary tree, return the postorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [3,2,1]

Follow up: Recursive solution is trivial, could you do it iteratively?
*/

--Iterative method:

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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res=new LinkedList();//LinkedList<Integer> rather than List<Integer> is necessary because the addFirst() method 
        Stack<TreeNode> stack=new Stack();
        while(root!=null||!stack.isEmpty()){
            if(root!=null){
                stack.push(root);
                res.addFirst(root.val);
                root=root.right;
            }
            else root=stack.pop().left;
        }
        return res;
    }
}

