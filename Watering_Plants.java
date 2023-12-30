class Solution {
    public int wateringPlants(int[] arr, int capacity) {
        int res = 0, n = arr.length;
        int c = capacity, i = -1;
        while(i < n-1){
            res++;
            i++;
            c -= arr[i];
            if(i < n-1 && c < arr[i+1]){
                c = capacity;
                res += (2*(i+1));
            }
        }
        return res;
    }
}
