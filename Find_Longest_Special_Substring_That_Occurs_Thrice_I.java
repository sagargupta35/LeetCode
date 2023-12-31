class Solution {
    public int maximumLength(String s) {
        Map<Character, TreeMap<Integer, Integer>> map = new HashMap<>();
        char c = s.charAt(0);
        int count = 0, n = s.length();
        for(int i = 0; i<n; i++){
            if(s.charAt(i) == c) count++;
            else{
                TreeMap<Integer, Integer> local = map.get(c);
                if(local == null){
                    local = new TreeMap<>(Map.of(count, 1));
                    map.put(c, local);
                } else{
                    local.merge(count, 1, Integer::sum);
                }
                c = s.charAt(i);
                count = 1;
            }
        }
        TreeMap<Integer, Integer> local = map.get(c);
        if(local == null){
            local = new TreeMap<>(Map.of(count, 1));
            map.put(c, local);
        } else{
            local.merge(count, 1, Integer::sum);
        }
        int res = -1;
        for(var entry: map.entrySet()){
            local = entry.getValue();
            while(!local.isEmpty()) {
                var entry2 = local.pollFirstEntry();
                int length = entry2.getKey();
                int freq = entry2.getValue();
                if (freq >= 3 || local.size() != 0) res = Math.max(res, length);
                else if(freq == 2 && length >= 2){
                    res = Math.max(res, length-1);
                }
                else if(length >= 3){
                    res = Math.max(res, length-2);
                }
            }
        }
        return res;
    }
}
