import java.util.*;
import java.io.*;

public class Main {

    static int N, X, max, count;
    static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for(int L = 0, R = 0; L <= N - X; L++) {
            while(R - L < X) {
                sum += A[R++];
            }

            if(sum == max) {
                count++;
            }
            if(sum > max) {
                max = sum;
                count = 1;
            }
            sum -= A[L];
        }

        if(max == 0) {
            System.out.println("SAD");
            return;
        }

        sb.append(max).append('\n');
        sb.append(count).append('\n');
        System.out.println(sb);
    }
}