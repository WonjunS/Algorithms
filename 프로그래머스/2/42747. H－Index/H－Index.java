import java.util.*;

class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        
        Arrays.sort(citations);
        
        Stack<Integer> stk = new Stack<>();
        for(int c : citations) {
            stk.push(c);
        }
        
        int N = citations.length;
        int last = Integer.MAX_VALUE;
        for(int h = N; h >= 0; h--) {
            while(!stk.isEmpty() && stk.peek() >= h) {
                int x = stk.pop();
            }
            
            int over = N - stk.size();
            int under = stk.size();
            
            if(over >= h && under <= h) {
                answer = h;
                break;
            }
        }
        
        return answer;
    }
}