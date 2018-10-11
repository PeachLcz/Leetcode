/*
Given a string s, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

Example 1:

Input: "aacecaaa"
Output: "aaacecaaa"
Example 2:

Input: "abcd"
Output: "dcbabcd"
*/
class Solution {
    public String shortestPalindrome(String s) {
        String temp=s+'#'+new StringBuilder(s).reverse().toString();
        int[] table=getTable(temp);
        return new StringBuilder(s.substring(table[table.length-1])).reverse().toString()+s;
    }
    private int[] getTable(String s){
        int[] table=new int[s.length()];
        
        int index=0;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(index)){
                table[i]=table[i-1]+1;
                index++;
            }
            else{
                index=table[i-1];
                while(index>0&&s.charAt(i)!=s.charAt(index)){
                    index=table[index-1];
                }
                if(s.charAt(index)==s.charAt(i))
                    index++;
            }
            table[i]=index;
        }
        return table;
    }
}
