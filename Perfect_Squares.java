class Solution {
    public int numSquares(int n) {
        Integer [] dp = new Integer [n];
        return numSquares(n, dp);
    }

    public int numSquares(int n, Integer [] dp) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        if(dp[n-1] != null) return dp[n-1];
        int k = (int)Math.sqrt(n);
        int min = n;
        for(int i = 2; i<=k; i++){
            int temp = numSquares(n-(i*i), dp)+1;
            min = Math.min(min, temp);
        }
        dp[n-1] = min;
        return min;
    }
}
