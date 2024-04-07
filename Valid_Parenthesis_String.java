class Solution {
    public boolean checkValidString(String s) {
        int count = 0, star = 0, n = s.length(), star2 = 0;
        boolean res = true;
        for(int i = 0; i<n; i++){
            if(s.charAt(i) == '('){
                count++;
            } else if(s.charAt(i) == ')'){
                if(count > 0) count--;
                else if(star2 > 0){
                    star2--;
                    star++;
                }
                else if(star > 0) star--;
                else{
                    res = false;
                    break;
                }
            } else{
                if(count > 0){
                    count--;
                    star2++;
                }
                else star++;
            }
        }
        if(!res) return false;
        return count == 0;
    }
}
