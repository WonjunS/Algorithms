import java.util.*;

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int dist = (2 * w) + 1;
        int left = 1;
        
        for(int i = 0; i < stations.length; i++) {
            int curr = stations[i];
            
            if(left < curr - w) {
                int length = (curr - w) - left;
                
                int count = length / dist;
                if(length % dist != 0) count++;
                
                answer += count;
            }
            
            left = curr + w + 1;
        }
        
        if(stations[stations.length - 1] + w < n) {
            left = stations[stations.length - 1] + w;
            
            int length = (n - left);
            
            int count = length / dist;
            if(length % dist != 0) count++;
            
            answer += count;
        }

        return answer;
    }
}