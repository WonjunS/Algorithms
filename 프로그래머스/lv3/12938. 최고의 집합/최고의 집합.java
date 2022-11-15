import java.util.*;

class Solution {
    
    public int[] solution(int n, int s) {
        int[] answer;
        
        if(s < n) {
            answer = new int[]{-1};
            return answer;
        }
        
        answer = new int[n];
        for(int i = 0; i < n; i++) {
            answer[i] = s / n;
        }
        
        for(int i = n - 1; i > n - (s % n) - 1; i--) {
            answer[i]++;
        }
        
        return answer;
    }
}