import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    
    static int N;
    static int[] arr;
    
    static void pro() {
        int L = 0, R = N - 1, v1 = 0, v2 = 0;
        int best_sum = Integer.MAX_VALUE;
        while(L < R) {
            int sum = arr[L] + arr[R];
            if(Math.abs(sum) < best_sum) {
                best_sum = Math.abs(sum);
                v1 = arr[L];
                v2 = arr[R];
            }
            
            if(sum < 0) {
                L++;
            } else {
                R--;
            }
        }
        sb.append(v1 + " " + v2);
        System.out.println(sb);
    }
    
    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        
        Arrays.sort(arr);
    }
    
    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}