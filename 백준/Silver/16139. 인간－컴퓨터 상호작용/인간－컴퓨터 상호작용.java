import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        
        int[][] count = new int[s.length() + 1][26];
        for(int i = 1; i <= s.length(); i++) {
            char c = s.charAt(i - 1);
            int idx = (int) c - 'a';
            for(int j = i; j <= s.length(); j++) {
                count[j][idx] += 1;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            int idx = (int) a - 'a';
            
            int total = count[r + 1][idx] - count[l][idx];
            
            sb.append(total).append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
}