import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int r = 0; r < enemy.length; r++) {
            pq.add(enemy[r]);
            
            if(pq.size() > k) {
                n -= pq.poll();
            }
            if(n < 0) {
                return r;
            }
        }
        
        return enemy.length;
    }
}