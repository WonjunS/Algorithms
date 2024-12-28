import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, answer;
    private static boolean[] visit;
    private static List<Integer>[] friendMap;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        friendMap = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            friendMap[i] = new ArrayList<>();
        }

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            friendMap[a + 1].add(b + 1);
            friendMap[b + 1].add(a + 1);
        }

        answer = 0;
        
        for(int i = 1; i <= N; i++) {
            if(answer != 1) {
                visit = new boolean[N + 1];
                visit[i] = true;
                search(i, 1);
            }
        }

        System.out.println(answer);
    }

    private static void search(int x, int depth) {
        if(depth == 5) {
            answer = 1;
            return;
        }
        
        for(int y : friendMap[x]) {
            if(visit[y]) continue;

            visit[y] = true;
            search(y, depth + 1);
            visit[y] = false;
        }
    }

}