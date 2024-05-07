class Solution {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0, new Boolean[s.length()+1][p.length()]);
    }

    public boolean isMatch(String s, String p, int st1, int st2, Boolean [][] dp) {
        if(st1 >= s.length() && st2 >= p.length()) return true;
        if(st2 >= p.length()) return false;
        if(st1 < s.length() && dp[st1][st2] != null) return dp[st1][st2];
        String curRegex = "";
        if(st2 == p.length()-1) curRegex += p.charAt(st2);
        else{
            curRegex = p.charAt(st2) + (p.charAt(st2+1) == '*' ? "*" : "");
        }
        if(curRegex.length() + st2 == p.length()){
            if(curRegex.length() == 1){
                if(st1 != s.length()-1) return dp[st1][st2] = false;
                return dp[st1][st2] =  f(curRegex, s.charAt(st1));
            }
            if(st1 >= s.length()) return true;
            for(int i = st1; i<s.length(); i++){
                if(!f(curRegex, s.charAt(i))) return dp[st1][st2] = false;
            }
            return dp[st1][st2] =  true;
        }
        if(curRegex.length() == 1){
            if(st1 >= s.length()) return dp[st1][st2] = false;
            if(!f(curRegex, s.charAt(st1))) return dp[st1][st2] = false;
            return dp[st1][st2] = isMatch(s, p, st1+1, st2+1, dp);
        }
        if(isMatch(s, p, st1, st2+2, dp)) return dp[st1][st2] = true;
        for(int i = st1; i<s.length(); i++){
            if(!f(curRegex, s.charAt(i))) break;
            if(isMatch(s, p, i+1, st2+2, dp)){
                return dp[st1][st2] = true;
            }
        }
        return dp[st1][st2] = false;
     }

     public boolean f(String s, char match){
        if(s.charAt(0) == '.') return true;
        return s.charAt(0) == match;
     }
}
