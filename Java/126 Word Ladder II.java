--Modification of 127 Word Ladder
--Bidirectional BFS    and    Dfs
class Solution {
    List<List<String>> res=new ArrayList();
    HashMap<String,List<String>> map=new HashMap();
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null||wordList.size()==0) return res;
        HashSet<String> dic=new HashSet(wordList);
        HashSet<String> start=new HashSet();
        HashSet<String> end=new HashSet();
        if(!dic.contains(endWord)) return res;
        start.add(beginWord);
        end.add(endWord);
        buildMap(start,end,dic,false);
        List<String> path=new ArrayList();
        path.add(beginWord);
        dfs(beginWord,endWord,path);
        return res;
    }
    public void buildMap(HashSet<String> start,HashSet<String> end,HashSet<String> dic,boolean reverse){
        if(start.size()==0) return;
        if(start.size()>end.size()){buildMap(end,start,dic,!reverse);return;}
        HashSet<String> next=new HashSet();
        dic.removeAll(start);
        boolean finished=false;
        for(String s:start){
            char[] arr=s.toCharArray();
            for(int i=0;i<arr.length;i++){
                char tmp=arr[i];
                for(char c='a';c<='z';c++){
                    if(c==tmp) continue;
                    arr[i]=c;
                    String nStr=new String(arr);
                    if(dic.contains(nStr)){
                        if(end.contains(nStr)) finished=true;
                        else next.add(nStr);
                        String key=reverse?nStr:s;
                        String val=reverse?s:nStr;
                        if(!map.containsKey(key)) map.put(key,new ArrayList());
                        map.get(key).add(val);
                    }
                }
                arr[i]=tmp;
            }
        }
        if(!finished) buildMap(next,end,dic,reverse);
    }
    public void dfs(String begin,String end,List<String> path){
        if(begin.equals(end)){
            res.add(new ArrayList(path));
            return;
        }
        if(!map.containsKey(begin)) return;
        for(String next:map.get(begin)){
            path.add(next);
            dfs(next,end,path);
            path.remove(path.size()-1);
        }
    }
}
