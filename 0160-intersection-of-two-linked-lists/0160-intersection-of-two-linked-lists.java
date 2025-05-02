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
        // Better Approach 
        ListNode temp1 = headA;
        ListNode temp2 = headB;
        int len1 = 0 , len2  = 0;
        while(temp1 != null){
            len1++;
            temp1 = temp1.next;
        }
        while(temp2 != null){
            len2++;
            temp2 = temp2.next;
        }
        if(len1 > len2){
            return collision(headA, headB, len1 - len2);
        }
        return collision(headB, headA, len2 - len1);
    }
    private ListNode collision(ListNode large, ListNode small, int dif){
        while(dif > 0){
            large = large.next;
            dif--;
        }
        while(large != small){
            large = large.next;
            small = small.next;
        }
        return large;
    }
}