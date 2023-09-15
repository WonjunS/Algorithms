import java.util.*;
import java.io.*;

public class Main {
    
    private static int count;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++) {
            String str = br.readLine();
            
            char[] s = str.toCharArray();
            
            count = 0;
            
            int result = isPalindrome(s);
            
            sb.append(result)
                .append(' ')
                .append(count)
                .append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
    private static int recursion(char[] s, int l, int r) {
        count++;
        if(l >= r) return 1;
        else if(s[l] != s[r]) return 0;
        return recursion(s, l + 1, r - 1);
    }
    
    private static int isPalindrome(char[] s) {
        return recursion(s, 0, s.length - 1);
    }
    
}