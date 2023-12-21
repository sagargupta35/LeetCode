class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1, j = 1;
        int n = nums.length;
        while(i < n && nums[i] != nums[i-1]){
            i++; j++;
        }
        while(j < n){
            while(j < n && nums[j] == nums[j-1]) j++;
            if(j < n) nums[i++] = nums[j++];
        }
        return i;
    }
}
