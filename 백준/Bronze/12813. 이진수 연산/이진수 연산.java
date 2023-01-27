import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        String A = sc.next();
        String B = sc.next();
        
        // 1. A & B
        String res1 = "";
        for(int i = 0; i < A.length(); i++) {
            char c1 = A.charAt(i);
            char c2 = B.charAt(i);
            
            if(c1 == '1' && c2 == '1') res1 += "1";
            else res1 += "0";
        }
        
        sb.append(res1).append('\n');
        
        // 2. A | B
        String res2 = "";
        for(int i = 0; i < A.length(); i++) {
            char c1 = A.charAt(i);
            char c2 = B.charAt(i);
            
            if(c1 == '1' || c2 == '1') res2 += "1";
            else res2 += "0";
        }
        sb.append(res2).append('\n');
        
        // 3. A ^ B
        String res3 = "";
        for(int i = 0; i < A.length(); i++) {
            char c1 = A.charAt(i);
            char c2 = B.charAt(i);
            
            if(c1 == '1' && c2 == '1') res3 += "0";
            else if(c1 == '1' && c2 == '0') res3 += "1";
            else if(c1 == '0' && c2 == '1') res3 += "1";
            else res3 += "0";
        }
        sb.append(res3).append('\n');
        
        // 4. ~A
        String res4 = "";
        for(int i = 0; i < A.length(); i++) {
            char c = A.charAt(i);
            
            if(c == '1') res4 += "0";
            else res4 += "1";
        }
        sb.append(res4).append('\n');
        
        // 5. ~B
        String res5 = "";
        for(int i = 0; i < B.length(); i++) {
            char c = B.charAt(i);
            
            if(c == '1') res5 += "0";
            else res5 += "1";
        }
        sb.append(res5).append('\n');
        
        System.out.println(sb);
    }
}