class Solution {
    public int firstMissingPositive(int[] arr) {
        int n = arr.length, cur = 0, tel = arr[0]-1;
        for(int i = 0; i<n; i++) if(arr[i] == 0) arr[i] = -1;
        while (cur < n){
            tel = arr[cur]-1;
            while (tel >= 0 && tel < n){
                int temp = arr[tel];
                arr[tel] = 0;
                tel = temp-1;
            }
            cur++;
        }
        cur = 1;
        while (cur <= n){
            if(arr[cur-1] != 0) break;
            cur++;
        }
        return cur;
    }
}
