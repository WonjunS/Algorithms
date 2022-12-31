import java.util.*;

public class Main {

    static int N, M;
    static long[] A, tree;

    static void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = A[start];
        } else {
            init(node * 2, start, (start + end) / 2);
            init(node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = Math.min(tree[node * 2], tree[node * 2 + 1]);
        }
    }

    static long query(int node, int start, int end, int left, int right) {
        if(left > end || right < start) {
            return Long.MAX_VALUE;
        }
        if(left <= start && right >= end) {
            return tree[node];
        }
        long l = query(node * 2, start, (start + end) / 2, left, right);
        long r = query(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return Math.min(l, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();
        M = sc.nextInt();

        A = new long[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        tree = new long[N * 4];

        init(1, 0, N - 1);

        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            sb.append(query(1, 0, N - 1, a - 1, b - 1)).append('\n');
        }

        System.out.println(sb);
    }
}