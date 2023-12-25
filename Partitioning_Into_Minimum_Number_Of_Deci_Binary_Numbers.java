class Solution {
    public int minPartitions(String s) {
        int max = 0, n = s.length();
        for(int i = 0; i<n; i++){
            max = Math.max(max, s.charAt(i)-'0');
            if(max == 9) break;
        }
        return max;
    }
}
