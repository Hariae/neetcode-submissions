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
    public boolean hasCycle(ListNode head) {

        //ListNode curr = head;        
        ListNode s = head;
        ListNode f = null;

        if (head != null && head.next != null) {
            f = head.next.next;
        } else {
            return false;
        }


        while (s != null && f != null) {
            
            if (s == f) {
                return true;
            }

            s = s.next;
            if (f.next != null) {
                f = f.next.next;
            } else {
                return false;
            }
            
            
        }   

        return false;
        
    }
}
