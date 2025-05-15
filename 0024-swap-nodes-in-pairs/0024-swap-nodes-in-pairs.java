/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode prev = null;
        while(temp != null && temp.next != null){
            ListNode prevNext = temp.next;
            ListNode next = temp.next.next;
            temp.next = null;
            if(temp == head){
                head = prevNext;
            }
            else{
                prev.next = prevNext;
            }
            prev = temp;
            prevNext.next = temp; 
            temp = next;
        }
        prev.next = temp;
        return head;
    }
}