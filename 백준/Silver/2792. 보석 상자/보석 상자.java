import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[M];
        int max = 0;
        for(int i = 0; i < M; i++) {
            int x = Integer.parseInt(br.readLine());
            max = Math.max(x, max);
            A[i] = x;
        }

        int left = 1, right = max;
        while(left < right) {
            int mid = (left + right) / 2;
            int total = binarySearch(mid);

            if(total > N) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        System.out.println(left);
    }

    private static int binarySearch(int x) {
        int total = 0;
        for(int a : A) {
            total += a / x;
            if(a % x != 0) total++;
        }

        return total;
    }

}