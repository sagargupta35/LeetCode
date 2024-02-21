class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        if(left == 0) return 0;
        if(left == right) return right;
        int f1 = (int)Math.floor(Math.log(left)/Math.log(2));
        int f2 = (int)Math.floor(Math.log(right)/Math.log(2));
        if(f1 != f2) return 0;
        int p1 = (int)Math.pow(2, f1+1);
        int p2 = p1-1;
        p1 /= 2;
        while (p1 > 0){
            int j1 = left&p1;
            int j2 = right&p1;
            if(j1 != j2) break;;
            p1 /= 2;
        }
        p2 ^= p1;
        p2 ^= (p1-1);
        return left & p2;
    }
}
