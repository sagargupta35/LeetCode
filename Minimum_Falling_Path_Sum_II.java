class Solution {
    public int minFallingPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(n == 1){
            return grid[0][0];
        }
        if(n == 2){
            return Math.min(grid[0][1]+grid[1][0], grid[1][1]+grid[0][0]);
        }
        int [][] mins = new int [n][3];
        Integer [][] dp = new Integer[n][3];
        for(int i = 0; i<n; i++){
            int min1 = Integer.MAX_VALUE,  min2 = Integer.MAX_VALUE,  min3 = Integer.MAX_VALUE;
            int i1 = -1, i2 = -1, i3 = -1;
            for(int j = 0; j<m; j++){
                if(grid[i][j] <= min1){
                    min3 = min2;
                    i3 = i2;
                    min2 = min1;
                    i2 = i1;
                    min1 = grid[i][j];
                    i1 = j;
                } else if(grid[i][j] <= min2){
                    i3 = i2;
                    min3 = min2;
                    min2 = grid[i][j];
                    i2 = j;
                } else if(grid[i][j] < min3){
                    i3 = j;
                    min3 = grid[i][j];
                }
            }
            mins[i][0] = i1; mins[i][1] = i2; mins[i][2] = i3;
        }
        return minFallingPathSum(grid, 0, -1, mins, dp);
    }

    public static int minFallingPathSum(int[][] grid, int i, int j, int [][] mins, Integer [][] dp) {
        int n = grid.length;
        int m = grid[0].length;
        if(i == n-1){
            int res = Integer.MAX_VALUE;
            for(int k = 0; k<3; k++){
                if(mins[i][k] != j){
                    res = Math.min(res, grid[i][mins[i][k]]);
                }
            }
            return res;
        }
        int res = Integer.MAX_VALUE;
        for(int k = 0; k < 3; k++){
            if(mins[i][k] != j){
                if(dp[i][k] == null){
                    dp[i][k] = grid[i][mins[i][k]] + minFallingPathSum(grid, i+1, mins[i][k], mins, dp);
                }
                res = Math.min(res, dp[i][k]);
            }
        }
        return res;
    }
}
