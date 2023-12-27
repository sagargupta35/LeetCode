class Solution {
    public int minOperations(int n) {
        if((n&1) == 1){
            n -= 1;
            return ((n/2)*(2 + n))/2;
        } else{
            n -= 1;
            return (((n + 1) / 2) * (1 + n))/2; 
        }
    }

}
