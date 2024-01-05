class Solution {
    public int[] restoreArray(int[][] adjacentPairs) {
        int n = adjacentPairs.length+1, next = 0;
        int [] res = new int [n];
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<n-1; i++){
            int first = adjacentPairs[i][0];
            int second = adjacentPairs[i][1];
            Integer j = map1.get(first);
            Integer k = map1.get(second);
            if(j == null) map1.put(first, second);
            else map2.put(first, second);
            if(k == null) map1.put(second, first);
            else map2.put(second, first);
        }
        int prev = 0;
        for(var i: map1.keySet()){
            if(map2.get(i) == null){
                prev = i;
                break;
            }
        }
        res[next++] = prev;
        set.add(prev);
        while (next < n){
            Integer cur = map1.get(prev);
            if(cur == null || set.contains(cur)) cur = map2.get(prev);
            set.add(cur);
            res[next++] = cur;
            prev = cur;
        }
        return res;
    }
}
