class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int [] res = new int [n];
        for(int i = 1; i<=n; i++){// i -> start
            for(int j = 1; j<=n; j++){// j -> end
                if(i != j) {
                    // i -> x -> y -> j
                    int d1 = Math.abs(x - i) + Math.abs(y - j) + 1;
                    // i -> y -> x -> j
                    int d2 = Math.abs(y - i) + Math.abs(x - j) + 1;
                    // i -> j
                    int d3 = Math.abs(j - i);
                    res[Math.min(d1, Math.min(d2, d3)) - 1]++;
                }
            }
        }
        return res;
    }
}
