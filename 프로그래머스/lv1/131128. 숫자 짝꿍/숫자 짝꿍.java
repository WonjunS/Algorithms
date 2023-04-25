import java.util.*;

class Solution {
    
    static StringBuilder sb;
    static int[] array_x, array_y;
    
    public String solution(String X, String Y) {
        String answer = "";
        
        sb = new StringBuilder();
        array_x = new int[10];
        array_y = new int[10];
        
        for(int i = 0; i < X.length(); i++) {
            int n = Character.getNumericValue(X.charAt(i));
            array_x[n]++;
        }
        
        for(int i = 0; i < Y.length(); i++) {
            int n = Character.getNumericValue(Y.charAt(i));
            array_y[n]++;
        }
        
        for(int i = 9; i >= 0; i--) {
            int min = Math.min(array_x[i], array_y[i]);
            for(int j = 0; j < min; j++) {
                sb.append(i);
            }
        }
        
        answer = sb.toString();
        
        if(answer.equals("")) {
            answer = "-1";
        }
        
        if(answer.startsWith("0")) {
            answer = "0";
        }
        
        return answer;
    }
}