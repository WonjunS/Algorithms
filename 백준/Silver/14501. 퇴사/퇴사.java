import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());

            int Ti = Integer.parseInt(st.nextToken());
            int Pi = Integer.parseInt(st.nextToken());

            T[i] = Ti;
            P[i] = Pi;
        }

        int[] DP = new int[N + 2];
        for(int i = 1; i <= N; i++) {
            if(T[i] + i <= N + 1) {
                DP[i + T[i]] = Math.max(DP[i] + P[i], DP[i + T[i]]);
            }

            DP[i + 1] = Math.max(DP[i], DP[i + 1]);
        }

        int answer = 0;
        for(int i = 1; i <= N + 1; i++) {
            answer = Math.max(answer, DP[i]);
        }

        System.out.println(answer);
    }

}