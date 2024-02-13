class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> [] dp = new ArrayList [n];
        return generateParenthesis(n, dp);
    }

    public List<String> generateParenthesis(int n, List<String> [] dp) {
        if(n == 0) return new ArrayList<>(List.of(""));
        if(n == 1) return new ArrayList<>(List.of("()"));
        if(dp[n-1] != null) return dp[n-1];
        List<String> list = new ArrayList<>();
        StringBuilder sbr;
        for(int i = n-1; i>=0; i--){
            List<String> inside = generateParenthesis(i, dp);
            List<String> outside = generateParenthesis(n-i-1, dp);
            for(var ins: inside){
                sbr = new StringBuilder();
                sbr.append("(").append(ins).append(")");
                for(var os : outside){
                    list.add(sbr + os);
                }
            }
        }
        return dp[n-1] = list;
    }
}
