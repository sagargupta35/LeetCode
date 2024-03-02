class Solution {
    public String countAndSay(int n) {
        if(n == 1) return "1";
        String s1 = countAndSay(n-1);
        StringBuilder sbr = new StringBuilder();
        char prev = s1.charAt(0);
        int i = 0;
        int count = 0;
        while (i < s1.length()){
            if(s1.charAt(i) == prev) count++;
            else{
                sbr.append(count).append(prev);
                count = 1;
                prev = s1.charAt(i);
            }
            i++;
        }
        sbr.append(count).append(prev);
        return sbr.toString();
    }
}
