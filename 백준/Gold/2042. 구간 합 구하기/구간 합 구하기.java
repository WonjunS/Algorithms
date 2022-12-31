import java.util.*;

public class Main {

    static int N, M, K;
    static long[] A, tree;

    static void init(int node, int start, int end) {
        if(start == end) {
            tree[node] = A[start];
        } else {
            init(node * 2, start, (start + end) / 2);
            init(node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    static void update(int node, int start, int end, int idx, long val) {
        if(idx < start || idx > end) {
            return;
        }
        if(start == end) {
            A[idx] = val;
            tree[node] = val;
            return;
        }
        update(node * 2, start, (start + end) / 2, idx, val);
        update(node * 2 + 1, (start + end) / 2 + 1, end, idx, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long query(int node, int start, int end, int left, int right) {
        if(left > end || right < start) {
            return 0;
        }
        if(left <= start && right >= end) {
            return tree[node];
        }
        long lsum = query(node * 2, start, (start + end) / 2, left, right);
        long rsum = query(node * 2 + 1, (start + end) / 2 + 1, end, left, right);
        return lsum + rsum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        A = new long[N];
        for(int i = 0; i < N; i++) {
            A[i] = sc.nextLong();
        }

        int h = (int) Math.ceil(Math.log(N) / Math.log(2));
        int tree_size = (1 << (h+1));
        tree = new long[tree_size];

        init(1, 0, N - 1);

        for(int i = 0; i < M + K; i++) {
            int a = sc.nextInt();

            if(a == 1) {
                int idx = sc.nextInt();
                long val = sc.nextLong();
                update(1, 0, N - 1, idx - 1, val);
            } else {
                int left = sc.nextInt();
                int right = sc.nextInt();
                sb.append(query(1, 0, N - 1, left - 1, right - 1)).append('\n');
            }
        }

        System.out.println(sb);
    }
}