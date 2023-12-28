class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> bigList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) map.merge(num, 1, Integer::sum);
        while(!map.isEmpty()){
            List<Integer> list = new ArrayList<>();
            Iterator<Map.Entry<Integer, Integer>> iterator = 
                    map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Integer, Integer> entry = iterator.next();
                list.add(entry.getKey());
                if (entry.getValue() == 1) {
                    iterator.remove(); 
                } else {
                    map.put(entry.getKey(), entry.getValue() - 1);
                }
            }
            bigList.add(list);
        }
        return bigList;
    }
}
