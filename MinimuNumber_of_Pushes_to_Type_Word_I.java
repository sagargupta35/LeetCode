class Solution {
    public int minimumPushes(String word) {
        int n = word.length();
        int sum = 0, fac = 1;
        while(n > 0){
            if(n >= 8){
                sum += (8*fac);
                fac++;
                n -= 8;
            }
            else{
                sum += (n*fac);
                break;
            } 
        }
        return sum;
    }
}
