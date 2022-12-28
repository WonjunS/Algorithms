import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[][] Dy_min, Dy_max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        Dy_min = new int[N + 1][3];
        Dy_max = new int[N + 1][3];

        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            Dy_max[i][0] = Math.max(Dy_max[i - 1][0], Dy_max[i - 1][1]) + a;
            Dy_max[i][1] = Math.max(Dy_max[i - 1][0], Math.max(Dy_max[i - 1][1], Dy_max[i - 1][2])) + b;
            Dy_max[i][2] = Math.max(Dy_max[i - 1][1], Dy_max[i - 1][2]) + c;

            Dy_min[i][0] = Math.min(Dy_min[i - 1][0], Dy_min[i - 1][1]) + a;
            Dy_min[i][1] = Math.min(Dy_min[i - 1][0], Math.min(Dy_min[i - 1][1], Dy_min[i - 1][2])) + b;
            Dy_min[i][2] = Math.min(Dy_min[i - 1][1], Dy_min[i - 1][2]) + c;
        }

        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int i = 0; i < 3; i++) {
            max = Math.max(max, Dy_max[N][i]);
            min = Math.min(min, Dy_min[N][i]);
        }

        sb.append(max).append(' ').append(min);

        System.out.println(sb);
    }
}