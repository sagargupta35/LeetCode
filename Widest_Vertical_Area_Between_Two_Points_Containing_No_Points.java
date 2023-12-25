import java.util.*;

class Solution {
    public int maxWidthOfVerticalArea(int[][] points) {
        int[] xpoints = new int[points.length];
        for(int i=0;i<xpoints.length;i++){
            xpoints[i] = points[i][0];
        }
        int max =-1;
        Arrays.sort(xpoints);
        for(int i=1;i<xpoints.length;i++){
            max = Math.max(max, (xpoints[i]-xpoints[i-1]));
        }

        return max;
    }
}
