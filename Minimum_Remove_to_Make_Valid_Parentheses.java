class Solution {
    public String minRemoveToMakeValid(String s) {
        int count = 0;
        StringBuilder sbr = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                sbr.append('(');
                count++;
            } else if(s.charAt(i) == ')'){
                if(count > 0){
                    sbr.append(')');
                    count--;
                }
            } else{
                sbr.append(s.charAt(i));
            }
        }
        int i = sbr.length()-1;
        while (count > 0){
            if(sbr.charAt(i) == '('){
                sbr.deleteCharAt(i);
                count--;
            }
            i--;
        }
        return sbr.toString();
    }
}
