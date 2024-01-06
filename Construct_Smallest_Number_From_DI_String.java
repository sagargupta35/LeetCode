class Solution {
    public String smallestNumber(String pattern) {
        boolean flag = true;
        StringBuilder sbr = new StringBuilder("1");
        int max = 1, cur = 1, i = 0, n = pattern.length();
        while(i < n){
            if(pattern.charAt(i) == 'I'){
                max++;
                cur = max;
                sbr.append(cur);
                flag = true;
            } else{
                if(flag){
                    int first = pattern.indexOf('I', i);
                    if(first == -1) first = n;
                    max += (first-i);
                    sbr.setCharAt(i, (char) (max+'0'));
                    cur = max-1;
                    flag = false;
                    sbr.append(cur);
                } else{
                    cur--;
                    sbr.append(cur);
                }
            }
            i++;
        }
        return sbr.toString();
    }
}
