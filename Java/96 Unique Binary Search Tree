/*
Given n, how many structurally unique BST's (binary search trees) that store values 1 ... n?

Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
   
   */
   -Attempt Approach: recursive solution:
   
   class Solution {
    public int numTrees(int n) {
        if(n==0) return 0;
        return numTreesHelper(1,n);
    }
    private int numTreesHelper(int start, int end){
        int count=0;
        if(start>end) return 1;
        if(start==end) return 1;
        for(int i=start;i<=end;i++){
           count+=numTreesHelper(start,i-1)*numTreesHelper(i+1,end); 
        }
        return count;
    }
}

--Problem!!! Time limited exceeded!! when the test case is n=14
--Because recursive solution takes too much time 

--Approvement: DP solution:
