/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/
- Approach1: Brute force
- Time Complexity:O(n^2)    Space Complexity:O(1)
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]+nums[j]==target)
                    return new int[]{i,j};     //pay attention to the syntax 
            }
        }
        throw new IllegalArgumentException("No two sum solution"); //pay attention to the syntax
    }
}

-Approach2: HashMap-- Trade space for speed, traverse the array twice
-Time Complexity:O(n)    Space Complexity:O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }
        for(int i=0;i<nums.length;i++){
            int newTarget=target-nums[i];
            if(map.containsKey(newTarget)&&map.get(newTarget)!=i) 
                return new int[]{i,map.get(newTarget)};
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}

-Approach3: Improvement of Approach2: traverse the array only once
-Time Complexity:O(n)    Space Complexity:O(n)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int newTarget=target-nums[i];
            if(map.containsKey(newTarget)) 
                return new int[]{i,map.get(newTarget)};
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}



