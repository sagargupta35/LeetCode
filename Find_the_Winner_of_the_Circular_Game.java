class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i<=n; i++) list.add(i);
        Function<Integer, Integer> fun = k1 -> k1 == 0 ? list.size()-1 : k1-1;
        int k1 = 0;
        while(list.size() > 1){
            k1 = (k1+k-1)%list.size();
            list.remove(k1);
        }
        return list.get(0);
    }
}
