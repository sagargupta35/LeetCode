class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int row = mat.length, col = mat[0].length;
        for(int i = 0; i<row; i++){
            for(int j = 1; j<col; j++){
                mat[i][j] += mat[i][j-1];
            }
        }
        int [][] ans = new int [row][col];
        for(int i = 0; i<row; i++){
            for(int j = 0; j<col; j++){
                ans[i][j] = blockSum(mat, Math.max(0, i-k), 
                Math.min(row-1, i+k), Math.max(0, j-k),
                 Math.min(col-1, j+k));
            }
        }
        return ans;
    }

    public static int blockSum(int [][] mat, int rs, int re, int cs, int ce){
        int sum = 0;
        for(int i = rs; i<= re; i++){
            sum += mat[i][ce];
            if(cs -1 >= 0) sum -= mat[i][cs-1];
        }
        return sum;
    }
}
