import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 1;
        
        Stack<Character> stk = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(stk.isEmpty()) {
                stk.push(c);
                continue;
            }
            if(stk.peek() == c) {
                stk.pop();
                continue;
            }
            stk.push(c);
            
        }
        
        if(!stk.isEmpty()) {
            answer = 0;
        }

        return answer;
    }
}