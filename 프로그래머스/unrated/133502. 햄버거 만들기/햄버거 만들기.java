import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        StringBuilder sb = new StringBuilder();
        
        int answer = 0;
        for(int i = 0; i < ingredient.length; i++) {
            int n = ingredient[i];
            
             if(sb.length() >= 3 && n == 1) {
                 if(sb.substring(sb.length() - 3, sb.length()).equals("123")) {
                     sb.delete(sb.length() - 3, sb.length());
                     answer++;
                     continue;
                 }
             }
             sb.append(n + "");
        }
        
        return answer;
    }
}