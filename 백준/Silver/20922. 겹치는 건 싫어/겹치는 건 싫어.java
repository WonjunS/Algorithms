import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] A = new int[N];
        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] count = new int[100001];
        
        int max = 0;
        int start = 0;
        int end = 0;
        while(end < N) {
            while(end < N && count[A[end]] + 1 <= K) {
                count[A[end]]++;
                end++;
            }
            int len = end - start;
            max = Math.max(len, max);
            count[A[start]]--;
            start++;
        }
        
        System.out.println(max);
    }
    
}