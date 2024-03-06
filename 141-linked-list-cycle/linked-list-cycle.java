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
        
        HashSet<ListNode> seen_nodes = new HashSet<>();

        ListNode current = head;

        seen_nodes.add(current);

        while (current.next != null){

            if (seen_nodes.contains(current.next)){
                return true;
            }


            current = current.next;
            seen_nodes.add(current);

        }

        return false;
        
    }
}