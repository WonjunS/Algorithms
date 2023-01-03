import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[] A;
    static long[] Dy;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        Dy = new long[K + 1];

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        Dy[0] = 1;
        Arrays.sort(A);
        for(int i = 0; i < N; i++) {
            int x = A[i];
            for(int j = x; j <= K; j++) {
                Dy[j] += Dy[j - x];
            }
        }

        System.out.println(Dy[K]);
    }
}