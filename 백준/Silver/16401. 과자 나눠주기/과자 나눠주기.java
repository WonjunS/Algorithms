import java.util.*;
import java.io.*;

public class Main {
    
    private static int M, N, answer;
    private static int[] L;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        L = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }
        
        answer = 0;
        
        binarySearch();
        
        System.out.println(answer);
    }
    
    static void binarySearch() {
        int left = 1, right = 1000000000;
        while(left <= right) {
            int mid = (left + right) / 2;
            int sum = 0;
            for(int i = 0; i < N; i++) {
                sum += L[i] / mid;
            }
            
            if(sum >= M) {
                left = mid + 1;
                answer = mid;
            } else {
                right = mid - 1;
            }
        }
    }
    
}