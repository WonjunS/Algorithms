import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        
        int[][] arr = new int[31][31];
        
        for(int i = 1; i <= 30; i++) {
            arr[i][1] = i;
        }
        
        for(int i = 2; i <= 30; i++) {
            for(int j = 2; j <= 30; j++) {
                arr[i][j] = arr[i - 1][j - 1] + arr[i - 1][j];
            }
        }
        
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int W = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            
            sb.append(arr[E][W]).append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
}