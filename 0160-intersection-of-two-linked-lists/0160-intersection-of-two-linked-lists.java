/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //Better Approach which takes O(1) space
        ListNode tempA = headA;
        // Now in this approach every time we move the tempA pointer one step we check if any of the nodes in B have the sameReferecne value or not 
        while(tempA != null){
            ListNode tempB = headB;
            while(tempB != null){
                if(tempA == tempB){
                    return tempA;
                }
                tempB = tempB.next;
            }
            tempA = tempA.next;
        }
        return null;
    }
}