/*
Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

Example 1:

add(1); add(3); add(5);
find(4) -> true
find(7) -> false
Example 2:

add(3); add(1); add(2);
find(3) -> true
find(6) -> false
*/
--If add more: add:O(1),find:O(n)
class TwoSum {
    Map<Integer,Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map=new HashMap();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number))
            map.put(number,2);
        else map.put(number,1);
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        Iterator<Integer> iter=map.keySet().iterator();
        while(iter.hasNext()){
            int num1=iter.next();
            int num2=value-num1;
            if(map.containsKey(num2))
                if(num2!=num1||map.get(num1)==2)
                    return true;
        }
        return false;
    }
}

--If find more:add(n),find(1)

class TwoSum {
    Set<Integer> num;
    Set<Integer> sum;
    /** Initialize your data structure here. */
    public TwoSum() {
        num=new HashSet();
        sum=new HashSet();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(num.contains(number))
            sum.add(number*2);
        else{
            Iterator<Integer> iter=num.iterator();
            while(iter.hasNext()){
                sum.add(iter.next()+number);
            }
            num.add(number);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        return sum.contains(value);
    }
}

