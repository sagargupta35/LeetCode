class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int [] res = new int [nums.length];
        int j = 0, k = 1;
        for (int num : nums) {
            if (num > 0) {
                res[j] = num;
                j += 2;
            } else {
                res[k] = num;
                k += 2;
            }
        }
        return res;
    }
}
