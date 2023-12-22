class Solution {
   public int searchInsert(int[] nums, int target) {
        int idx = binarySearch(nums, 0, nums.length-1, target);
        if(idx < 0) return 0;
        if(nums[idx] >= target) return idx;
        return idx+1;
    }

    public static int binarySearch(int [] arr, int st, int end, int target){
        if(st >= end) return end;
        int mid = st + (end-st)/2;
        if(arr[mid] < target){
            st = mid+1;
            return binarySearch(arr, st, end, target);
        } else if(arr[mid] > target){
            end = mid-1;
            return binarySearch(arr, st, end, target);
        } else return mid;
    }
}
