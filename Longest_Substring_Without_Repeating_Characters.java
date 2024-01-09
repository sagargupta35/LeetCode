class Solution {
        public int lengthOfLongestSubstring(String s) {
            if(s.length() == 0) return 0;
            Map<Character, int []> map = new HashMap<>();
            int rep = 1, count = 0, max = -1, n = s.length();
            int [] local;
            for(int i = 0; i<n; i++){
                local = map.get(s.charAt(i));
                if(local == null || local[0] != rep){
                    count++;
                    local = new int [] {rep, i};
                    map.put(s.charAt(i), local);
                } else{
                    i = local[1]+1;
                    rep++;
                    max = Math.max(max, count);
                    count = 1;
                    map.put(s.charAt(i), new int [] {rep, i});
                }
            }
            max = Math.max(max, count);
            return max;
        }
}
