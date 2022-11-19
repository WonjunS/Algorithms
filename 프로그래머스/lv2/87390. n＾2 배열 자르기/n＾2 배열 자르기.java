import java.util.*;

class Solution {
    public List<Integer> solution(int n, long left, long right) {
        List<Integer> answer = new ArrayList<>();
       
        long start = (left / n) + 1;
        long end = (right / n) + 1;
        long idx = (start - 1) * n;
        for(int i = (int) start; i <= (int) end; i++) {
            for(int j = 1; j <= i; j++) {
                if(idx >= left && idx <= right) answer.add(i);
                idx++;
            }
            int count = i;
            for(int j = i + 1; j <= n; j++) {
                if(count == n) break;
                if(idx >= left && idx <= right) answer.add(j);
                idx++;
                count++;
            }
        }
        
        return answer;
    }
}