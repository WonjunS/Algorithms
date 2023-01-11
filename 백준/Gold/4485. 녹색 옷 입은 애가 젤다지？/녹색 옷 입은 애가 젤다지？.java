import java.util.*;
import java.io.*;

public class Main {

    static class Node {
        private int x;
        private int y;
        private int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    static int N;
    static int[][] map;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int idx = 1;
        while(true) {
            N = Integer.parseInt(br.readLine());

            if(N == 0) break;

            map = new int[N][N];
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int cost = dijkstra();

            sb.append("Problem " + idx + ": ");
            sb.append(cost).append('\n');
            idx++;
        }

        System.out.println(sb);
    }

    static int dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> (o1.cost - o2.cost));
        int[][] dist = new int[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                dist[i][j] = 1000000;
            }
        }
        dist[0][0] = map[0][0];
        pq.add(new Node(0, 0, dist[0][0]));

        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if(dist[node.x][node.y] != node.cost) continue;

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dir[i][0];
                int ny = node.y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(dist[nx][ny] <= dist[node.x][node.y] + map[nx][ny]) continue;

                dist[nx][ny] = dist[node.x][node.y] + map[nx][ny];
                pq.add(new Node(nx, ny, dist[nx][ny]));
            }
        }
        return dist[N - 1][N - 1];
    }
}