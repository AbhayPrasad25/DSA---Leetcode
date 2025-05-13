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
    public ListNode partition(ListNode head, int x) {
        ListNode l = new ListNode(0);
        ListNode r = new ListNode(0);
        ListNode h1 = l;
        ListNode h2 = r;
        ListNode temp = head;
        while(temp != null){
            if(temp.val < x){
                l.next = temp;
                l = l.next; 
            }
            else if(temp.val >= x){
                r.next = temp;
                r = r.next;
            }
            temp = temp.next;
        }
        l.next = h2.next;
        r.next = null;
        return h1.next;
    }
}