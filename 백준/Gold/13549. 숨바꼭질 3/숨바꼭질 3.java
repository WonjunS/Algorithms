import java.util.*;

public class Main {

    static class Node {
        private int idx;
        private int time;

        public Node(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    static int N, K, min;
    static boolean[] visit;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
    }

    static void pro() {
        min = Integer.MAX_VALUE;
        visit = new boolean[100001];

        bfs(N);

        System.out.println(min);
    }

    static void bfs(int x) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, 0));

        while(!q.isEmpty()) {
            Node now = q.poll();
            x = now.idx;
            int t = now.time;
            visit[x] = true;

            if(x == K) {
                min = Math.min(min, now.time);
            }

            if(x * 2 <= 100000 && !visit[x * 2]) {
                q.add(new Node(x * 2, t));
            }
            if(x + 1 <= 100000 && !visit[x + 1]) {
                q.add(new Node(x + 1, t + 1));
            }
            if(x - 1 >= 0 && !visit[x - 1]) {
                q.add(new Node(x - 1, t + 1));
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}