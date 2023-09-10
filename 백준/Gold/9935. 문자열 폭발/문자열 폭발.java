import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Stack<Character> stk = new Stack<>();
        
        String str = br.readLine();
        String pattern = br.readLine();
        
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            stk.push(c);
            
            String sub = "";
            if(c == pattern.charAt(pattern.length() - 1)) {
                int idx = pattern.length() - 1;
                while(!stk.isEmpty() && idx >= 0) {
                    char t = stk.peek();
                    if(t != pattern.charAt(idx)) {
                        break;
                    }
                    
                    sub = t + sub;
                    stk.pop();
                    idx--;
                }
                
                if(idx != -1) {
                    for(int j = 0; j < sub.length(); j++) {
                        stk.push(sub.charAt(j));
                    }
                }
            }

        }

        if(stk.isEmpty()) {
            System.out.println("FRULA");
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stk.isEmpty()) {
            char c = stk.pop();
            sb.append(c);
        }
        
        System.out.println(sb.reverse().toString());
    }
    
}