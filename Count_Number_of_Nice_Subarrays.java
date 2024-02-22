public int numberOfSubarrays(int[] nums, int k) {
        int left = 0, right = 0, count = 0, first = -1, last = -1, n = nums.length, res = 0;
        while (right < n){
            if((nums[right]&1) == 1){
                count++;
            }
            if(count == 1 && first == -1){
                first = right;
            }
            if(count == k && last == -1){
                last = right;
            } else if(count == k+1){
                res += (right-last)*(first-left+1);
                left = first+1;
                first = findNextOdd(left, nums);
                count = k;
                last = right;
            }
            right++;
        }
        if(last != -1){
            res += (right-last)*(first-left+1);
        }
        return res;
    }

    public static int findNextOdd(int st, int [] arr){
        for(int i = st; i<arr.length; i++){
            if((arr[i]&1) == 1) return i;
        }
        return -1;
    }
