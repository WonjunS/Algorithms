import java.util.*;
import java.io.*;

public class Main {

    static int M, N, L, ans;
    static int[] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        arr = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(arr);
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            if(y > L) continue;
            
            int upper = x + (L - y);
            int lower = x - (L - y);
            int left = 0, right = M - 1;
            while(left <= right) {
                int mid = (left + right) / 2;
                if(arr[mid] >= lower && arr[mid] <= upper) {
                    ans++;
                    break;
                } else if(arr[mid] < lower) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        System.out.println(ans);
    }
}