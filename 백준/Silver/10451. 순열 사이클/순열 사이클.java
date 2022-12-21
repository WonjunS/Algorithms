import java.util.*;
import java.io.*;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static int T, N;
    static int[] arr;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++) {
            int ans = 0;
            N = Integer.parseInt(br.readLine());
            arr = new int[N + 1];
            visit = new boolean[N + 1];
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for(int j = 1; j <= N; j++) {
                if(visit[j]) continue;
                visit[j] = true;
                solve(j, j);
                ans++;
            }
            sb.append(ans).append('\n');
        }

        System.out.println(sb);
    }

    static void solve(int x, int ori) {
        if(arr[x] == ori) {
            return;
        } else {
            visit[arr[x]] = true;
            solve(arr[x], ori);
        }
    }
}