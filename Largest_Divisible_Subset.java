class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> [] dp = new ArrayList [nums.length];
        Arrays.sort(nums);
        return largestDivisibleSubset(nums, dp, nums.length-1, 0);
    }

    public List<Integer> largestDivisibleSubset(int[] arr, List<Integer> [] dp, int st, int div)  {
        if(st == 0){
            if(div % arr[st] == 0){
                return new ArrayList<>(List.of(arr[st]));
            } else return new ArrayList<>();
        }
        List<Integer> with;
        if(dp[st] == null){
            with = new ArrayList<>(largestDivisibleSubset(arr, dp, st-1, arr[st]));
            with.add(arr[st]);
            dp[st] = with;
        } else with = dp[st];
        List<Integer> without = largestDivisibleSubset(arr, dp, st-1, div);
        if(div % arr[st] == 0){
            if(with.size() >= without.size()) return with;
            return without;
        }
        return without;
    }
}
