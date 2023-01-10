import java.util.*;
import java.io.*;

public class Main {

    static int N, x, count;
    static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        x = Integer.parseInt(br.readLine());

        Arrays.sort(A);

        int L = 0, R = N - 1;
        while(L < R) {
            int sum = A[L] + A[R];

            if(sum == x) count++;
            if(sum > x) R--;
            else L++;
        }

        System.out.println(count);
    }
}