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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevNode = null;
        while(temp != null){
            ListNode kNode = KthNode(temp , k);
            //KthNode is NULL then break from the loop
            if(kNode == null){
                if(prevNode != null){
                    prevNode.next = temp;
                }
                break;
            }
            ListNode next = kNode.next;
            kNode.next = null;
            reverse(temp);
            if(temp == head){
                head = kNode;
            }
            else{
                prevNode.next = kNode;
            }
            prevNode = temp;
            temp = next;
        }
        return head;
    }
    private ListNode KthNode(ListNode node, int k){
        while(node != null && k > 1){
            node = node.next;
            k--;
        }
        return node;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}