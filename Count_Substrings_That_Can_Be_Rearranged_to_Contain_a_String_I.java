class Solution {
    public long validSubstringCount(String word1, String word2) {
        int [] arr = new int [26];
        int [] req = new int [26];
        for (int i = 0; i < word2.length(); i++) {
            req[word2.charAt(i)-'a']++;
        }
        int left = word1.length()-1;
        int cnt = 0;
        for (int i = 0; i <26; i++) {
            if(req[i] > 0) cnt++;
        }
        long sum = 0;
        for (int i = word1.length()-1; i >= 0; i--) {
            int cur = word1.charAt(i)-'a';
            while (left >= 0 && cnt > 0){
                int temp = word1.charAt(left)-'a';
                arr[temp]++;
                left--;
                if(arr[temp] == req[temp]) cnt--;
            }
            if(cnt == 0){
                sum += left+2;
            }
            arr[cur]--;
            if(arr[cur] < req[cur]) cnt++;
        }
        return sum;
    }
}
