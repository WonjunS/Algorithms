import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int x : works){
            pq.add(x);
        }
        
        while(n-- > 0) {
            if(pq.isEmpty()) return answer;
            int max = pq.poll();
            if(max == 1) continue;
            pq.add(max - 1);
        }
        
        for(int x : pq) {
            answer += (long) x * (long) x;
        }
        
        return answer;
    }
}