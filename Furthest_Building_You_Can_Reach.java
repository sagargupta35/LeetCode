class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int n = heights.length;
        PriorityQueue<Integer> pq = 
                new PriorityQueue<>(Comparator.reverseOrder());
        long sum = 0;
        int res = 0;
        for(int i = 1; i<n; i++){
            if(heights[i] > heights[i-1]){
                int j = heights[i]-heights[i-1];
                pq.add(j);
                if(sum + j <= bricks){
                    sum += j;
                    res = i;
                } else{
                    if(ladders > 0){
                        sum -= pq.poll();
                        ladders--;
                        sum += j;
                        res = i;
                    } else break;
                }
            } else res = i;
        }
        return res;
    }
}
