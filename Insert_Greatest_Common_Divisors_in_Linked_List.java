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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode nxt = head.next;
        if(nxt == null) return head;
        ListNode gcd = new ListNode(findGCD(head.val, nxt.val), nxt);
        head.next = gcd;
        insertGreatestCommonDivisors(gcd.next);
        return head;
    }

    private static int findGCD(int a, int b) {
        if(a%b==0)
        {
            return b;
        }
        
        return findGCD(b,a%b);
    }
}
