import java.util.*;
import java.io.*;

public class Main {
    
    private static boolean[] isNotPrimary;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        isNotPrimary = new boolean[1000001];
        
        preprocess();
        
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            
            int count = 0;
            for(int i = 1; i <= N / 2; i++) {
                int a = i;
                int b = N - i;
                
                if(!isNotPrimary[a] && !isNotPrimary[b]) {
                    count++;
                }
            }
            
            sb.append(count).append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
    private static void preprocess() {
        isNotPrimary[1] = true;

        for(int i = 3; i <= 1000000; i++) {
            for(int j = 2; j <= Math.sqrt(i); j++) {
                if(i % j == 0) {
                    isNotPrimary[i] = true;
                    break;
                }
            }
        }
    }
    
}