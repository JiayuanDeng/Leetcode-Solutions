/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }
    
    public ListNode merge(ListNode[] lists, int l, int r){
        if (l < r){
            int m = (r - l) / 2 + l;
            return mergeTwoLists(merge(lists, l, m), merge(lists, m + 1, r));
        }
        else return lists[l];
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
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