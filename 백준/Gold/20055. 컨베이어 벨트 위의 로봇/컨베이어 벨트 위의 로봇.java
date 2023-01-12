import java.util.*;
import java.io.*;

public class Main {

    static int N, K;
    static int[] A;
    static boolean[] exist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[2 * N + 1];
        exist = new boolean[2 * N + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= 2 * N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int step = 1;
        while(true) {

            // Step 1
            turn();

            // Step 2
            for(int i = N - 1; i > 0; i--) {
                if(!exist[i]) continue;
                if(!exist[i + 1] && A[i + 1] > 0) {
                    exist[i + 1] = true;
                    exist[i] = false;
                    A[i + 1]--;
                }
                if(i + 1 == N) {
                    exist[i + 1] = false;
                }
            }

            // Step 3
            if(!exist[1] && A[1] >= 1) {
                exist[1] = true;
                A[1]--;
            }

            // Step 4
            int count = 0;
            for(int i = 1; i <= 2 * N; i++) {
                if(A[i] == 0) count++;
            }

            if(count >= K) break;

            step++;
        }

        System.out.println(step);
    }

    static void turn() {
        int[] A_backup = new int[2 * N + 1];
        boolean[] exist_backup = new boolean[2 * N + 1];
        for(int i = 1; i <= 2 * N; i++) {
            A_backup[i] = A[i];
            exist_backup[i] = exist[i];
        }

        for(int i = 1; i <= 2 * N; i++) {
            if(i == 1) {
                A[i] = A_backup[2 * N];
                exist[i] = exist_backup[2 * N];
                continue;
            }
            A[i] = A_backup[i - 1];
            exist[i] = exist_backup[i - 1];
            if(i == N && exist[i]) exist[i] = false;
        }
    }
}