class Solution {
    public int countVowelStrings(int n) {
        int [][] dp = new int [n][5];
        int res = 0, i  =0;
        while(i < 5){
            res += countVowelStrings(0, dp, i++, n);
        }
        return res;
    }

    public static int countVowelStrings(int n, int [][] dp, int x, int l){
        if(l-n-1 == 0) return 1;
        if(dp[l-n-1][x] != 0) return dp[l-n-1][x];
        int res = 0, i = x;
        while(i < 5){
            res += countVowelStrings(n+1, dp,  i++, l);
        }
        dp[l-n-1][x] = res;
        return res;
     }
}
