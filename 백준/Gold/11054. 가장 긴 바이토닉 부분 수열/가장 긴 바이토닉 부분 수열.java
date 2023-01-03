import java.util.*;
import java.io.*;

public class Main {

    static int N, max;
    static int[] A, Dy_asc, Dy_des;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        A = new int[N];
        Dy_asc = new int[N];
        Dy_des = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        ascending();
        descending();

        for(int k = 0; k < N; k++) {
            int len = Dy_asc[k] + Dy_des[k] - 1;

            max = Math.max(max, len);
        }

        System.out.println(max);
    }

    static void ascending() {
        Dy_asc[0] = 1;
        for(int i = 1; i < N; i++) {
            int k = A[i];
            Dy_asc[i] = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(k > A[j]) {
                    Dy_asc[i] = Math.max(Dy_asc[i], Dy_asc[j] + 1);
                }
            }
        }
    }

    static void descending() {
        Dy_des[N - 1] = 1;
        for(int i = N - 2; i >= 0; i--) {
            int k = A[i];
            Dy_des[i] = 1;
            for(int j = i + 1; j < N; j++) {
                if(k > A[j]) {
                    Dy_des[i] = Math.max(Dy_des[i], Dy_des[j] + 1);
                }
            }
        }
    }
}