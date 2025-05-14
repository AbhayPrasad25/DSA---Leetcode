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
    public int pairSum(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        ListNode prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            fast = fast.next.next;
            slow = slow.next;
        }
        //Reverese the next Mid Part
        ListNode newHead = null;
        ListNode mid = slow;
        prev.next = null;
        while(mid != null){
            ListNode next = mid.next;
            mid.next = newHead;
            newHead = mid;
            mid = next;
        }
        int max = -1;
        while(head != null && newHead != null){
            max = Math.max(max , head.val + newHead.val);
            head = head.next;
            newHead = newHead.next;
        }
        return max;
    }
}