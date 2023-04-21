import java.util.*;

class Solution {
    
    static int answer;
    static int[] A;
    
    public int solution(int number, int limit, int power) {
        A = new int[number + 1];
        for(int i = 1; i <= number; i++) {
            for(int j = 1; j <= number / i; j++) {
                A[i * j]++;
            }
        }
        
        for(int i = 1; i <= number; i++) {
            int k = A[i];
            
            if(k <= limit) {
                answer += k;
            } else {
                answer += power;
            }
        }
        
        return answer;
    }
}