class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        Integer [] dp = new Integer [arr.length];
        return maxSumAfterPartitioning(arr, k, dp, arr.length-1);
    }

    public static int maxSumAfterPartitioning(int [] arr, int k, Integer [] dp, int st){
        if(st < 0) return 0;
        if(st == 0) return arr[0];
        if(dp[st] != null) return dp[st];
        int val = Integer.MIN_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 1; i<=k; i++){ // i-> size of sub array
            if(st-i+1 < 0) break;
            max = Math.max(max, arr[st-i+1]);
            int pre = maxSumAfterPartitioning(arr, k, dp, st-i);
            val = Math.max(val, (max*i)+pre);
        }
        return dp[st] = val;
    }
}
