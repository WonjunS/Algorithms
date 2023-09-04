import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int[] dist = new int[N];
        int[] price = new int[N + 1];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            dist[i] = x;
        }
        
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i < N + 1; i++) {
            int x = Integer.parseInt(st.nextToken());
            price[i] = x;
        }
        
        long cost = price[1] * dist[1];
        int k = 2;
        while(k < N) {
            int t = k + 1;
            long need = price[k] * dist[k];
            long x = need; // 이번에 다음꺼까지 넣는 거
            long y = need; // 다음에 넣는 거
            while(true) {
                if(t == N) {
                    cost += y;
                    break;
                }
                if(x + (price[k] * dist[t]) >= y + (price[t] * dist[t])) {
                    cost += y;
                    break;
                }
                
                x = x + (price[k] * dist[t]);
                y = x;
                t++;
            }
            if(k == t) {
                k++;
            } else {
                k = t;
            }
        }
        
        System.out.println(cost);
    }
    
}