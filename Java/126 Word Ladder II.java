--Modification of 127 Word Ladder
--Bidirectional BFS    and    Dfs
class Solution {
    List<List<String>> res=new ArrayList();
    HashMap<String,List<String>> map=new HashMap();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null) return res;
        Set<String> dict=new HashSet(wordList);
        Set<String> beginSet=new HashSet();
        Set<String> endSet=new HashSet();
        if(!dict.contains(endWord)) return res;
        beginSet.add(beginWord);
        endSet.add(endWord);
        buildMap(beginSet,endSet,dict,false);
        List<String> path=new ArrayList();
        path.add(beginWord);
        dfs(beginWord,endWord,path);
        return res;
    }
    private void buildMap(Set<String> beginSet,Set<String> endSet,Set<String> dict,boolean reverse){
        if(beginSet.size()==0) return;
        if(beginSet.size()>endSet.size()){
            buildMap(endSet,beginSet,dict,!reverse);
            return;
        }
        boolean finished=false;
        Set<String> next=new HashSet();
        dict.removeAll(beginSet);
        for(String s:beginSet){
            char[] arr=s.toCharArray();
            for(int i=0;i<arr.length;i++){
                char temp=arr[i];
                for(char ch='a';ch<='z';ch++){
                    if(ch==temp) continue;
                    arr[i]=ch;
                    String nStr=new String(arr);
                    if(dict.contains(nStr)){
                        if(endSet.contains(nStr))
                            finished=true;
                        else next.add(nStr);
                        String key=reverse?nStr:s;
                        String val=reverse?s:nStr;
                        if(!map.containsKey(key)) map.put(key,new ArrayList());
                        map.get(key).add(val);
                    }
                }
                arr[i]=temp;
            }
        }
        if(!finished) buildMap(next,endSet,dict,reverse);
    }
    private void dfs(String beginWord,String endWord,List<String> path){
        if(beginWord.equals(endWord)){
            res.add(new ArrayList(path));
            return;
        }
        if(!map.containsKey(beginWord))
            return;
        for(String next:map.get(beginWord)){
            path.add(next);
            dfs(next,endWord,path);
            path.remove(path.size()-1);
        }
    }
}
