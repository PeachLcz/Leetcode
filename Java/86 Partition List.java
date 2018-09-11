/*Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

Example:

Input: head = 1->4->3->2->5->2, x = 3
Output: 1->2->2->4->3->5
*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
- Approach : the fundamental principle is to seperate the list to 2 distinct lists and combine them afterwards

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode smallerHead=new ListNode(0);//smallerHead and biggerHead are two dump nodes,point to smaller list and bigger list
        ListNode biggerHead=new ListNode(0);
        ListNode smaller=smallerHead;
        ListNode bigger=biggerHead;
        while(head!=null){
            if(head.val<x){
                smaller.next=head;
                smaller=smaller.next;
            }
            else{
                bigger.next=head;
                bigger=bigger.next;
            }
            head=head.next;
        }
        smaller.next=biggerHead.next;
        bigger.next=null;
        return smallerHead.next;
            
    }
}
