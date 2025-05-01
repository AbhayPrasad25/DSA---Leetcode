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
        //Brute Force
        //Create a hashSet to store the node reference of linkedList a
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while(temp != null){
            set.add(temp);
            temp = temp.next;
        }
        //Now iterating the Second list to find the Point of Intersection based on the Node References
        ListNode tempB = headB;
        while(tempB != null){
            if(set.contains(tempB)){
                return tempB;
            }
            tempB = tempB.next;
        }
        // We return null since we dont find a point of Intersection
        return null;
    }
}