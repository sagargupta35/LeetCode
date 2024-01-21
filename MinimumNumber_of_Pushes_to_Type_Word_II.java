class Solution {
    public int minimumPushes(String word) {
        int [] arr = new int [26];
        int sum = 0, n = word.length();
        for(int i = 0; i<n; i++) arr[word.charAt(i)-'a']++;
        Arrays.sort(arr);
        for(int i = 25, fac = 1, j = 1; i>=0 && arr[i] > 0; i--, j = (int)Math.ceil((fac+1)/8f), fac++){
            sum += arr[i]*j;
        }
        return sum;
    }
}
