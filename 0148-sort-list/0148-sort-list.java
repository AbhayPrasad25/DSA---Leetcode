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
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    private ListNode merge(ListNode temp, ListNode temp2){
        ListNode dummy1 = new ListNode(0);
        ListNode dummy = dummy1;
        ListNode l1 = temp;
        ListNode l2 = temp2;
        while(l1 != null && l2 != null){
            if(l1.val <= l2.val){
                dummy.next = l1;
                l1 = l1.next;
            }
            else{
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        while(l1 != null){
            dummy.next = l1;
            l1 = l1.next;
        }
        while(l2 != null){
            dummy.next = l2;
            l2 = l2.next;
        }
        return dummy1.next;
    } 
}