class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int [] arr = new int [k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        int n = logs.length;
        for(int i = 0; i<n; i++){
            int finalI = i;
            map.merge(logs[i][0], new HashSet<>(
                    Set.of(logs[i][1])), (old, newSet) -> {
                old.add(logs[finalI][1]);
                return old;
            });
        }
        for(var entry: map.entrySet()){
            arr[entry.getValue().size()-1]++;
        }
        return arr;
    }
}
