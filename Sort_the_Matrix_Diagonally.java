class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for(int i = 0; i<m; i++){
            diagonalSort(mat, i, 0, m, n);
        }
        for(int j = 1; j<n; j++){
            diagonalSort(mat, 0, j, m, n);
        }
        return mat;
    }

    public static void diagonalSort(int [][] mat, 
        int row, int col, int m, int n){
        int [] freq = new int [101];
        for(int i = row, j = col; i<m&&j<n; i++, j++){
            freq[mat[i][j]]++;
        }
        int i = row, j = col;
        for(int k = 0; k<101; k++){
            while(freq[k]-- > 0){
                mat[i++][j++] = k;
            }
        }
    }
}
