class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int [][] arr = new int [rowSum.length][colSum.length];
        int n = rowSum.length, m = colSum.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                while (j < m && colSum[j] == 0) j++;
                if(j < m) {
                    if (rowSum[i] > colSum[j]) {
                        arr[i][j] = colSum[j];
                        rowSum[i] -= colSum[j];
                        colSum[j] = 0;
                    } else{
                        arr[i][j] = rowSum[i];
                        colSum[j] -= rowSum[i];
                        rowSum[i] = 0;
                        break;
                    }
                }
            }
        }
        return arr;
    }
}
