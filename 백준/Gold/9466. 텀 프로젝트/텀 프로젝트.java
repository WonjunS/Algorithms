import java.util.*;
import java.io.*;

public class Main {

    private static int n, cnt;
    private static int[] numbers;
    private static boolean[] visit, cycleChecked;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-- > 0) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            numbers = new int[n + 1];
            for(int i = 1; i <= n; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }

            cnt = 0;
            visit = new boolean[n + 1];
            cycleChecked = new boolean[n + 1];
            for(int i = 1; i <= n; i++) {
                if(cycleChecked[i]) continue;
                dfs(i);
            }

            sb.append(n - cnt).append('\n');
        }

        System.out.println(sb.toString());
    }

    private static void dfs(int x) {
        if(visit[x]) {
            cycleChecked[x] = true;
            cnt++;
        } else {
            visit[x] = true;
        }

        if(!cycleChecked[numbers[x]]) {
            dfs(numbers[x]);
        }

        visit[x] = false;
        cycleChecked[x] = true;
    }

}