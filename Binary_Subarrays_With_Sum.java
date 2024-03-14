class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       int prev = -1, left = -1, right = -1, cur = 0, sum = 0, res = 0;
        if(goal == 0){
            while (cur < nums.length){
                if(nums[cur] == 0) sum++;
                else{
                    res += ((sum)*(sum+1))/2;
                    sum = 0;
                }
                cur++;
            }
            res += ((sum)*(sum+1))/2;
            return res;
        }
        while (cur < nums.length){
            sum += nums[cur];
            if(sum == goal && right == -1) right = cur;
            if(left == -1 && nums[cur] == 1) left = cur;
            if(sum > goal){
                sum -= nums[left];
                res += (cur-right)*(left-prev);
                prev = left;
                left++;
                while (left < cur && nums[left] == 0) left++;
                right = cur;
            }
            cur++;
        }
        if(sum == goal){
            res += (cur-right)*(left-prev);
        }
        return res;
    }
}
