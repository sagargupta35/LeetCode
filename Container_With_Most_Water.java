class Solution {
    public int maxArea(int[] height) {
        int n = height.length, i = 0, j = n-1, max = -1;
        while (i < j){
            max = Math.max((j-i)*Math.min(height[i], height[j]), max);
            if(height[i] <= height[j]) i++;
            else j--;
        }
        return max;
    }
}
