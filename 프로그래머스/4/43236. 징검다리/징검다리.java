import java.util.*;

class Solution {
    public int solution(int distance, int[] rocks, int n) {
        Arrays.sort(rocks);
        
        int[] d = new int[rocks.length + 1];
        d[0] = rocks[0];
        d[d.length - 1] = distance - rocks[rocks.length - 1];
        
        for(int i = 1; i < rocks.length; i++) {
            d[i] = rocks[i] - rocks[i - 1];
        }
        
        int left = 1;
        int right = distance + 1;
        
        while(left < right) {
            int mid = (left + right) / 2;
            
            int cnt = 0;
            int dist = 0;
            
            for(int i = 0; i < d.length; i++) {
                dist += d[i];
                
                if(dist < mid) {
                    cnt++;
                } else {
                    dist = 0;
                }
            }
            
            if(cnt <= n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return left - 1;
    }
}