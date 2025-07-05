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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode Mid = getMid(head);
        ListNode temp2 = Mid.next;
        Mid.next = null;
        ListNode head1 = sortList(head);
        ListNode head2 = sortList(temp2);
        return merge(head1, head2);
    }
    private ListNode getMid(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode merge(ListNode temp, ListNode temp2){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        ListNode l1 = temp;
        ListNode l2 = temp2;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                tail.next = l1;
                l1 = l1.next;
            }
            else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if(l1 != null){
            tail.next = l1;
        }
        if(l2 != null){
            tail.next = l2;
        }
        return dummy.next;
    } 
}