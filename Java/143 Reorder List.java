/*
Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You may not modify the values in the list's nodes, only nodes itself may be changed.

Example 1:

Given 1->2->3->4, reorder it to 1->4->2->3.
Example 2:

Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 --Step 1 Reverse the half rear part
 --Step 2 Reorder one by one
class Solution {
    public void reorderList(ListNode head) {
        if(head==null) return;
        ListNode fast=head;
        ListNode slow=head;
        while(fast.next!=null&&fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }//1->2->3->4->5->6
        ListNode middle=slow;//3
        ListNode preCurrent=middle.next;//4
        while(preCurrent!=null&&preCurrent.next!=null){
            // switch from: 1->2->3->4->5->6
            //to:           1->2->3->5->4->6
            //switch from:  1->2->3->5->4->6
            //to:           1->2->3->6->5->4
            ListNode current=preCurrent.next;
            preCurrent.next=current.next;
            current.next=middle.next;
            middle.next=current;
        }
        ListNode head1=head;
        ListNode head2=middle.next;
        //switch from:1->2->3->6->5->4
        //to:         1->6->2->5->3->4
        while(head1!=middle){
            head2=head2.next;
            middle.next.next=head1.next;
            head1.next=middle.next;
            middle.next=head2;
            head1=head1.next.next;
        }
    }
}
