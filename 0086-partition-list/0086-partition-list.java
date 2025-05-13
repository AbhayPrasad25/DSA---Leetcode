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
        ListNode bfStart = null;
        ListNode bfend = null;
        ListNode afstart = null;
        ListNode afend = null;
        while(head != null){
            ListNode next = head.next;
            head.next = null;
            if(head.val < x){
                if(bfStart == null){
                    bfStart = head;
                    bfend = bfStart;
                }
                else{
                    bfend.next = head;
                    bfend = head;
                }
            }
            else{
                if(afstart == null){
                    afstart = head;
                    afend = afstart;
                }
                else{
                    afend.next = head;
                    afend = head;
                }
            }
            head = next;
        }
        if(bfStart == null){
            return afstart;
        }
        bfend.next = afstart;
        return bfStart;
    }
}