/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // if (l1 == null || l2 == null) return null;
        int val, val1, val2, carry;
        ListNode n1 = l1;
        ListNode n2 = l2;
        ListNode prev;
        ListNode cur;
        
        // Create the first node
        val = n1.val + n2.val;
        
        carry = val / 10;
        val = val % 10;
        
        ListNode first = new ListNode(val);
        cur = first;
        
        // Create the other nodes
        while (true){
            if (n1.next == null && n2.next == null && carry == 0) break;
            
            prev = cur;
            if (n1.next == null)
                val1 = 0;
            else {
                n1 = n1.next;
                val1 = n1.val;
            }
            if (n2.next == null)
                val2 = 0;
            else {
                n2 = n2.next;
                val2 = n2.val;
            }
            
            val = val1 + val2 + carry;
            carry = val / 10;
            val = val % 10;
            
            cur = new ListNode(val);
            prev.next = cur;
        }
        
        return first;
    }
}