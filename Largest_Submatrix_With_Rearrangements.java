class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int count = 0, n = matrix.length, m = matrix[0].length;
        for(int i = 1; i<n; i++){
            for(int j = 0; j<m; j++){
                if(matrix[i][j] == 1){
                    matrix[i][j] = matrix[i][j] + matrix[i-1][j];
                }
            }
        }

        for (int[] ints : matrix) {
            Arrays.sort(ints);
            for (int j = m - 1, k = 1; j >= 0; j--, k++) {
                count = Math.max(count, k * ints[j]);
            }
        }
        return count;
    }
}
