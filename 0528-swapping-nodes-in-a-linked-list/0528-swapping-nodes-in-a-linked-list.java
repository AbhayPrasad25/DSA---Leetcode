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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode ptr1 = head;
        int count = 1;
        while(count < k){
            ptr1 = ptr1.next;
            count++;
        }
        ListNode second = ptr1;
        ListNode ptr2 = head;
        while(second.next != null){
            ptr2 = ptr2.next;
            second = second.next;
        }
        int temp = ptr1.val;
        ptr1.val = ptr2.val;
        ptr2.val = temp;
        return head;
    }
}