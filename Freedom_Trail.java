class Solution {
    public int findRotateSteps(String ring, String key) {
        Integer [][] dp = new Integer[ring.length()][key.length()];
        List<Integer> [] indices = new ArrayList [26];
        Arrays.setAll(indices, i -> new ArrayList<>());
        for(int i = 0; i<ring.length(); i++){
            int cur = ring.charAt(i)-'a';
            indices[cur].add(i);
        }
        return findRotateSteps(key, 0, 0, dp, indices, ring.length())+key.length();
    }

    public static int findRotateSteps( String key, int prev, int st, Integer [][] dp, List<Integer> [] indices, int len) {
        if(dp[prev][st] != null) return dp[prev][st];
        int n = key.length();
        if(st == n-1){
            int res = Integer.MAX_VALUE;
            for(int cur : indices[key.charAt(st)-'a']){
                int j = Math.abs(cur-prev);
                res = Math.min(res, Math.min(j, len-j));
            }
            return dp[prev][st] = res;
        }
        int res = Integer.MAX_VALUE;
        for(int cur : indices[key.charAt(st)-'a']){
            int j = Math.abs(cur-prev);
            res = Math.min(res, Math.min(j, len-j) + findRotateSteps(key, cur, st+1, dp, indices, len));
        }
        return dp[prev][st] = res;
    }
}
