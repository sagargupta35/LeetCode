class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> fre = new HashMap<>();
        int left = 0, right = 0, n = nums.length, max = 0;
        while (right < n){
            int f = fre.merge(nums[right], 1, Integer::sum);
            if(f > k){
                max = Math.max(max, right-left);
                int key = nums[right];
                while (left <= right){
                    fre.compute(nums[left], (m, val) -> val-1);
                    if(key == nums[left]){
                        left++;    
                        break;
                    }
                    left++;
                }
            }
            right++;
        }
        max = Math.max(max, right-left);
        return max;
    }
}
