class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int max = 0;
        for(int i = 0; i<nums.length; i++) max |= nums[i];
        return memoise(nums, max, 0, 0);
    }

    public static int memoise(int [] arr, int n, int st, int prev){
        if (st == arr.length - 1) {
            int res = 0;
            if (prev == n) res = 2;
            else if ((prev | arr[st]) == n) res = 1;
            return res;
        }
        int res = memoise(arr, n, st + 1, prev);
        res += memoise(arr, n, st + 1, prev | arr[st]);
        return res;
    }
}
