import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int n : B) pq.add(n);
        
        Arrays.sort(A);
        for(int i = A.length - 1; i >= 0; i--) {
            int a = A[i];
            int b = pq.peek();
            if(pq.isEmpty()) break;
            if(b > a) {
                pq.poll();
            }
        }
        
        return B.length - pq.size();
    }
}