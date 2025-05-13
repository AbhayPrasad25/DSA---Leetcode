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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int count = size(head);
        k = k % count;
        ListNode rptr = head;
        for(int i = 0; i < k ; i++){
            rptr = rptr.next;
        }
        ListNode lptr = head;
        while(rptr.next != null){
            lptr = lptr.next;
            rptr = rptr.next;
        }
        if(lptr == rptr){
            return head;
        }
        ListNode newhead = lptr.next;
        lptr.next = null;
        ListNode temp = newhead;
        while(temp != null && temp.next != null){
            temp = temp.next;
        }
        temp.next = head;
        return newhead;
    }
    private int size(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }
}