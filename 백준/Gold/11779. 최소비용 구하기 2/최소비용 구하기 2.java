import java.util.*;
import java.io.*;

public class Main {

    static class Route {
        private int city;
        private int cost;

        public Route(int city, int cost) {
            this.city = city;
            this.cost = cost;
        }
    }

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, A, B, count;
    static int[] costs, arr;
    static ArrayList<Route>[] adj;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adj = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            adj[from].add(new Route(to, cost));
        }

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        dijkstra(A);

        sb.append(costs[B]).append('\n');

        Stack<Integer> stk = new Stack<>();
        int last = B;
        stk.push(last);
        while(arr[last] != 0) {
            count++;
            stk.push(arr[last]);
            last = arr[last];
        }
        
        sb.append(stk.size()).append('\n');
        while(!stk.isEmpty()) {
            sb.append(stk.pop()).append(' ');
        }

        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Route> pq = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
        costs = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            costs[i] = Integer.MAX_VALUE;
        }
        costs[start] = 0;
        pq.add(new Route(start, 0));

        while(!pq.isEmpty()) {
            Route route = pq.poll();

            if(route.cost != costs[route.city]) continue;

            for(Route r : adj[route.city]) {
                if(costs[r.city] <= costs[route.city] + r.cost) continue;
                costs[r.city] = costs[route.city] + r.cost;
                pq.add(new Route(r.city, costs[r.city]));
                arr[r.city] = route.city;
            }
        }
    }

}