import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        String s = br.readLine();
        int q = Integer.parseInt(br.readLine());
        
        int[][] count = new int[s.length()][26];
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int idx = (int) c - 'a';
            count[i][idx] = 1;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char a = st.nextToken().charAt(0);
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            
            int idx = (int) a - 'a';
            int total = 0;
            for(int j = l; j <= r; j++) {
                total += count[j][idx];
            }
            
            sb.append(total).append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
}