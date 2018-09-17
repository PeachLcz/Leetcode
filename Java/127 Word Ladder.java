/*
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:

Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.
Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.
Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/

--BFS

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict=new HashSet<String>(wordList);
        Queue<String> q=new LinkedList<>();
        q.add(beginWord);
        int step=0;
        while(!q.isEmpty()){
            step++;
            int size=q.size();
            while(size-->0){
                String word=q.remove();
                for(int i=0;i<beginWord.length();i++){
                    StringBuffer sb=new StringBuffer(word);
                    for(char ch='a';ch<='z';ch++){
                        sb.setCharAt(i,ch);
                        String newWord=sb.toString();
                        if(!dict.contains(newWord))
                            continue;
                        if(newWord.equals(endWord)) 
                            return step+1;
                        q.add(newWord);
                        dict.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
