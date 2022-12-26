import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N;
    static int[] arr;

    static void input() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    static void pro() {
        Arrays.sort(arr);

        long best_sum = Long.MAX_VALUE;
        int v1 = 0, v2 = 0, v3 = 0;
        for(int i = 0; i < N - 2; i++) {
            int target = -arr[i];
            int L = i + 1;
            int R = N - 1;
            while(L < R) {
                if(best_sum > Math.abs(-(long) target + arr[L] + arr[R])) {
                    best_sum = Math.abs(-(long) target + arr[L] + arr[R]);
                    v1 = -target;
                    v2 = arr[L];
                    v3 = arr[R];
                }
                if(arr[L] + arr[R] > target) R--;
                else L++;
            }
        }

        sb.append(v1).append(' ').append(v2).append(' ').append(v3);
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}