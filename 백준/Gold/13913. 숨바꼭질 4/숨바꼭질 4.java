import java.util.*;
import java.io.*;

public class Main {

    private static int N, K;
    private static int[] T;
    private static int[] move = {1, -1, 2};
    private static StringBuilder sb;

    private static class Movement {
        private int position;
        private int time;
        private String route;

        public Movement(int position, int time, String route) {
            this.position = position;
            this.time = time;
            this.route = route;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        T = new int[100001];

        T = Arrays.stream(T)
            .map(x -> Integer.MAX_VALUE)
            .toArray();

        sb = new StringBuilder();

        if(N > K) {
            sb.append(N - K).append('\n');
            for(int i = N; i >= K; i--) {
                sb.append(i).append(' ');
            }
        } else {
            bfs();
        }

        System.out.println(sb.toString());
    }

    private static void bfs() {
        PriorityQueue<Movement> pq = new PriorityQueue<>((o1, o2) -> o1.time - o2.time);
        Movement movement = new Movement(N, 0, N + "");
        pq.add(movement);
        T[N] = 0;

        boolean flag = true;

        while(!pq.isEmpty()) {
            Movement m = pq.poll();
            int position = m.position;
            int time = m.time;
            String route = m.route;

            if(position == K) {
                sb.append(T[K]).append('\n');
                sb.append(route);
                flag = false;
            }

            if(!flag) break;

            for(int n : move) {
                int nx = -1;
                if(n == 2) {
                    nx = position * 2;
                } else {
                    nx = position + n;
                }

                if(nx < 0 || nx > 100000) continue;
                if(T[nx] <= time + 1) continue;

                Movement m2 = new Movement(nx, time + 1, route + " " + nx);
                pq.add(m2);
                T[nx] = time + 1;
            }
        }
    }

}