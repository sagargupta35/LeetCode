class Solution {
    public String convert(String s, int numRows) {
        if(s.length() < numRows) return s;
        if(numRows == 1) return s;
        StringBuilder sbr = new StringBuilder(s);
        int n = s.length(), j = 2*(numRows-1), k = 0;
        for(int i = 0; i<n; i+=j) sbr.setCharAt(k++, s.charAt(i));
        for(int i = 1; i<numRows-1; i++){
            sbr.setCharAt(k++, s.charAt(i));
            for(int a = j; (a-i)<n; a += j){
                sbr.setCharAt(k++, s.charAt(a-i));
                if(a+i < n) sbr.setCharAt(k++, s.charAt(a+i));
            }
        }
        for(int i = numRows-1; i<n; i+=j) sbr.setCharAt(k++, s.charAt(i));
        return sbr.toString();
    }
}
