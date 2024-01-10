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
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int rowMin = -1, rowMax = m, colMin = -1, colMax = n;
        boolean flag = true, colMove = true, rowMove = true;
        int [][] mat = new int [m][n];
        for(int i = 0; i<m; i++){
            Arrays.fill(mat[i], -1);
        }
        while (head != null){
            int i, j;
            if(flag){
                if(colMove){
                    i = rowMin+1; j = colMin+1;
                    head = move(mat, head, i, j, colMax, false, true);
                    rowMin++;
                    colMove = false;
                } else{
                    i = rowMax-1; j = colMax-1;
                    head = move(mat, head, i, j, colMin, false, false);
                    colMove = true;
                    rowMax--;
                }
                flag = false;
            } else{
                if(rowMove){
                    i = rowMin+1; j = colMax-1;
                    head = move(mat, head, i, j, rowMax, true, true);
                    colMax--;
                    rowMove = false;
                } else{
                    i = rowMax-1; j = colMin+1;
                    head = move(mat, head, i, j, rowMin, true, false);
                    colMin++;
                    rowMove = true;
                }
                flag = true;
            }
        }
        return mat;
    }

    public static ListNode move(int [][] mat, ListNode head, int i, int j, int limit, boolean row, boolean inc){
        if(row){
            if(inc){
                while (head != null && i < limit){
                    mat[i++][j] = head.val;
                    head  = head.next;
                }
            } else{
                while (head != null && i > limit){
                    mat[i--][j] = head.val;
                    head  = head.next;
                }
            }
        } else{
            if(inc){
                while (head != null && j < limit){
                    mat[i][j++] = head.val;
                    head  = head.next;
                }
            } else{
                while (head != null && j > limit){
                    mat[i][j--] = head.val;
                    head  = head.next;
                }
            }
        }
        return head;
    }
} 
