import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        
        long d = 1;
        for(int i = 1; i <= n; i++) {
            d *= (long) i;
            list.add(i);
        }
        
        k--;
        int idx = 0;
        while(idx < n) {
            d /= n - idx;
            answer[idx++] = list.remove((int) (k / d));
            k %= d;
        }
        
        return answer;
    }
}