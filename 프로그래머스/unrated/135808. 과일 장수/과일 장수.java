import java.util.*;

class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        
        Arrays.sort(score);
        
        if(m > score.length) {
             return answer;
        }
        
        int n = score.length;
        for(int i = 1; i <= n / m; i++) {
            int min = score[n - (m * i)];
            
            answer += min * m;
        }
        
        return answer;
    }
}