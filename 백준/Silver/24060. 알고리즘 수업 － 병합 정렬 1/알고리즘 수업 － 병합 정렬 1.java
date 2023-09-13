import java.util.*;
import java.io.*;

public class Main {
    
    private static int N, K, answer, count;
    private static int[] A, tmp;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        A = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;
        answer = -1;
        
        tmp = new int[N + 1];
        mergeSort(1, N);

        System.out.println(answer);
    }
    
    private static void mergeSort(int p, int r) {
        if(p < r) {
            int q = (p + r) / 2;
            mergeSort(p, q);
            mergeSort(q + 1, r);
            merge(p, q, r);
        }
    }
    
    private static void merge(int p, int q, int r) {
        int i = p, j = q + 1, t = 1;
        
        while(i <= q && j <= r) {
            if(A[i] <= A[j]) {
                tmp[t++] = A[i++];
            } else {
                tmp[t++] = A[j++];
            }
        }
        
        while(i <= q) {
            tmp[t++] = A[i++];
        }
        
        while(j <= r) {
            tmp[t++] = A[j++];
        }
        
        i = p; t = 1;
        while(i <= r) {
            count++;
            if(count == K) {
                answer = tmp[t];
            }
            A[i++] = tmp[t++];
        }
    }
    
}