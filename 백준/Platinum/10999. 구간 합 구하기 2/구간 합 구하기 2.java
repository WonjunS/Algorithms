import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;

    static int N, M, K;
    static long[] A, tree, lazy;

    static void init(int node, int start, int end) {
        if(start == end) {
            tree[node] = A[start];
        } else {
            init(node * 2, start, (start + end) / 2);
            init(node * 2 + 1, (start + end) / 2 + 1, end);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    static void propagate(int node, int start, int end) {
        if(lazy[node] != 0) {
            if(start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            tree[node] += lazy[node] * (end - start + 1);
            lazy[node] = 0;
        }
    }

    static void update(int node, int start, int end, int left, int right, long val) {
        propagate(node, start, end);
        if(right < start || left > end) {
            return;
        }
        if(left <= start && right >= end) {
            lazy[node] = val;
            propagate(node, start, end);
            return;
        }
        update(node * 2, start, (start + end) / 2, left, right, val);
        update(node * 2 + 1, (start + end) / 2 + 1, end, left, right, val);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static long query(int node, int start, int end, int left, int right) {
        propagate(node, start, end);
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new long[N];
        lazy = new long[N * 4];
        tree = new long[N * 4];
        for(int i = 0; i < N; i++) {
            A[i] = Long.parseLong(br.readLine());
        }

        init(1, 0, N - 1);

        for(int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 1) {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                long d = Long.parseLong(st.nextToken());
                update(1, 0, N - 1, b - 1, c - 1, d);
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sb.append(query(1, 0, N - 1, b - 1, c - 1)).append('\n');
            }
        }

        System.out.println(sb);
    }
}