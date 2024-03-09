class Solution {
    public int removeAlmostEqualCharacters(String word) {
        Integer [] dp = new Integer [word.length()];
        return removeAlmostEqualCharacters(word, 0, dp);
    }

    static int removeAlmostEqualCharacters(String s, int st, Integer [] dp) {
        if(st >= s.length()-1) return 0;
        if(s.length() == 1) return 0;
        if(dp[st] != null) return dp[st];
        if(Math.abs(s.charAt(st) - s.charAt(st+1)) <= 1) return dp[st] = Math.min(removeAlmostEqualCharacters(s, st+1, dp), removeAlmostEqualCharacters(s, st+2, dp))+1;
        return removeAlmostEqualCharacters(s, st+1, dp);
    }
}
