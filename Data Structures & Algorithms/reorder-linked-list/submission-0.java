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
    public void reorderList(ListNode head) {

        // finding midd point

        ListNode s = head, f = head.next;

        while (f != null && f.next != null) {
            
            s = s.next;
            f = f.next.next;
        }

       // System.out.println(s.val);
        ListNode curr = s.next;
        ListNode prev = s.next = null;
        

        // reverse

        while(curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // setting mid point next to reversed linkedlist's head
        // s.next = prev; 
        

        // log
        // curr = head;
        // while(curr != null) {
        //     System.out.print(curr.val + " -> ");
        //     curr = curr.next;
        // }

        // merge alternate
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;


        }


        
    }
}
