import java.util.Stack;

class Solution {
    
    public String solution(String p) {
        String answer = solve(p);
        
        return answer;
    }
    
    static String solve(String w) {
        if(w.equals("")) {
            return w;
        }
        
        int left = 0, right = 0, i = 0;
        for(i = 0; i < w.length(); i++) {
            if(w.charAt(i) == '(') left++;
            if(w.charAt(i) == ')') right++;
            if(left == right) break;
        }
        
        String u = w.substring(0, i + 1);
        String v = w.substring(i + 1);
        
        if(isCorrect(u)) {
            v = solve(v);
        }
        
        if(!isCorrect(u)) {
            String str = "(";
            str = str + solve(v);
            str = str + ")";
            
            for(int j = 1; j < u.length() - 1; j++) {
                if(u.charAt(j) == '(') str = str + ")";
                if(u.charAt(j) == ')') str = str + "(";
            }
            
            return str;
        }
        
        return u + v;
    }
    
    static boolean isCorrect(String s) {
        Stack<Character> stk = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == '(') stk.push(c);
            else {
                if(stk.isEmpty()) return false;
                else stk.pop();
            }
        }
        
        if(stk.size() > 0) return false;
        
        return true;
    }
}