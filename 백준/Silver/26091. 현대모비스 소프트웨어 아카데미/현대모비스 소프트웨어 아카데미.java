import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static int[][] A;
    private static boolean[][] hideCloud, cloud;
    private static int[][] dirs = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(A);

        int start = 0;
        int end = N - 1;
        int cnt = 0;
        while(start < end) {
            int a1 = A[start];
            int a2 = A[end];

            if(a1 + a2 >= M) {
                start++;
                end--;
                cnt++;
            } else {
                start++;
            }
        }

        System.out.println(cnt);
    }

}