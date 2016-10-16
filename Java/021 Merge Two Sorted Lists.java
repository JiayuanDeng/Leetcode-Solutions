/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode start = new ListNode(Integer.MIN_VALUE);
        ListNode current = start;
        while (l1 != null || l2 != null){
            if (l2 == null || (l1 != null && l1.val <= l2.val)){
                current.next = l1;
                current = current.next;
                l1 = l1.next;
            }
            else if (l1 == null || (l2 != null && l1.val > l2.val)){
                current.next = l2;
                current = current.next;
                l2 = l2.next;
            }
        }
        return start.next;
    }
}