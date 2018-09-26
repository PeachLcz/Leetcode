/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/

class DLinkedNode{
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;
    public DLinkedNode(int key,int value){
        this.key=key;
        this.value=value;
    }
}
class LRUCache {
    class DLinkedNode{
    int key;
    int value;
    DLinkedNode pre;
    DLinkedNode post;
    public DLinkedNode(int key,int value){
        this.key=key;
        this.value=value;
    }
}
    private Map<Integer,DLinkedNode> cache;
    private int capacity;
    private DLinkedNode head;
    private DLinkedNode tail;
    public LRUCache(int capacity) {
        cache=new HashMap();
        this.capacity=capacity;
        head=new DLinkedNode(0,0);
        tail=new DLinkedNode(0,0);
        head.pre=null;
        head.post=tail;
        tail.pre=head;
        tail.post=null;
    }
    private void deleteNode(DLinkedNode node){
        node.post.pre=node.pre;
        node.pre.post=node.post;
    }
    private void addToHead(DLinkedNode node){
        node.post=head.post;
        head.post.pre=node;
        head.post=node;
        node.pre=head;
    }
    public int get(int key) {
        if(cache.containsKey(key)){
            DLinkedNode node=cache.get(key);
            deleteNode(node);
            addToHead(node);
            return node.value;
        }
        return -1;
    }
    public void put(int key, int value) {
        if(cache.containsKey(key)){
            DLinkedNode node=cache.get(key);
            node.value=value;
            deleteNode(node);
            addToHead(node);
        }
        else{
            DLinkedNode newNode=new DLinkedNode(key,value);
            if(cache.size()<capacity){
                cache.put(key,newNode);
                addToHead(newNode);
            }
            else{
                cache.remove(tail.pre.key);
                cache.put(key,newNode);
                deleteNode(tail.pre);
                addToHead(newNode);
            }
        }
    }
}
