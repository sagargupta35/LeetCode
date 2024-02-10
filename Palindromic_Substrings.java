class Solution {
    public int countSubstrings(String s) {
        int sum = 0, n = s.length();
        
        //odd length strings:
        for(int i = 0; i<n; i++){
            int left = i, right = i;
            while (left >= 0 && right < n){
                if(s.charAt(left) == s.charAt(right)){
                    sum++;
                    left--; right++;
                } else break;
            }
        }
        
        //even length substrings:
        for(int i = 0; i<n-1; i++){
            int left = i, right = i+1;
            while (left >= 0 && right < n){
                if(s.charAt(left) == s.charAt(right)){
                    sum++;
                    left--;
                    right++;
                } else break;
            }
        }
        
        return sum;
    }
}
