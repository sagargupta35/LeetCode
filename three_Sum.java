class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        int ind = 0, n = nums.length;
        Arrays.sort(nums);
        while (ind < n-2){
            int i = ind+1, j = n-1, target = -nums[ind];
            while (i < j){
                int sum = nums[i] + nums[j];
                if(sum == target){
                    triplets.add(List.of(nums[i], nums[j], nums[ind]));
                    int prevBack = nums[i], prevFro = nums[j];
                    while (i < j && nums[i] == prevBack) i++;
                    while (i < j && nums[j] == prevFro) j--;
                } else if(sum < target) i++;
                else j--;
            }
            target = nums[ind];
            while(ind < n-2 && nums[ind] == target) ind++;
        }
        return triplets;
    }
}
