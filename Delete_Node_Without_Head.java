/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        while(next != null){
            node.val = next.val;
            ListNode prev = node;
            node = next;
            next = node.next;
            if(next == null){
                prev.next = null;
            }
        }
        node = null;
    }
}
