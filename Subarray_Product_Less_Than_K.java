class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0, right = 0, n = nums.length, res = 0;
        long prod = 1;
        while (right < n){
            prod *= nums[right];
            if(prod >= k){
                int temp = left;
                while (left <= right && prod >= k){
                    prod /= nums[left];
                    left++;
                }
                long len = Math.min(right, left) - temp;
                len = (len * (len+1))/2;
                res += (int)len;
                if(left < right){
                    res += (left-temp)*(right-left);
                }
            }
            right++;
        }
        long len = right-left;
        len = (len * (len+1))/2;
        res += (int) len;
        return res;
    }
}
