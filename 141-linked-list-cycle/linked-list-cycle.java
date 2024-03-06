/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {

        if (head == null){
            return false;
        }

        ListNode current = head;
        ListNode current_after = head;

        while (current.next != null && current.next.next != null ){

            current = current.next.next;
            current_after = current_after.next;

            if (current == current_after){
                return true;
            }
            
        }

        return false;
        
        }

        
    }
