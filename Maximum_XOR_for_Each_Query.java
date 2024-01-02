class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int pow = 1;
        pow <<= maximumBit;
        pow -= 1;
        int [] arr = new int [n];
        int i = 0, j = n-1, x = 0;
        for(int k = 0; k<n; k++) x ^= nums[k];
        while (j >= 0){
            arr[i++] = pow^x;
            x ^= nums[j--];
        }
        return arr;
    }
}
