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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Long, ListNode> map = new HashMap<>();
        ListNode cur = head;
        long preSum = 0;
        boolean flag = true;
        while (flag){
            flag = false;
            while (cur != null){
                long temp = preSum+cur.val;
                if (temp == 0){
                    map.clear();
                    head = cur.next;
                }
                if(map.containsKey(temp)){
                    preSum = temp;
                    ListNode prev = map.get(temp);
                    ListNode cur2 = prev.next;
                    prev.next = cur.next;
                    while (cur2 != cur){
                        temp += cur2.val;
                        if(map.get(temp) == cur2) map.remove(temp);
                        cur2 = cur2.next;
                    }
                    flag = true;
                } else{
                    preSum = temp;
                    map.putIfAbsent(temp, cur);
                }
                cur = cur.next;
            }
        }
        return head;
    }
}
