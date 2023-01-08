import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;

    static final int MOD = 1000000007;
    static int N, M, K;
    static int[] A;
    static long[] tree;

    static void init(int node, int start, int end) {
        if(start == end) {
            tree[node] = A[start] % MOD;
            return;
        } else {
            int mid = (start + end) / 2;
            init(node * 2, start, mid);
            init(node * 2 + 1, mid + 1, end);
            tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % MOD;
        }
    }

    static void update(int node, int start, int end, int idx, int val) {
        if(idx < start || idx > end) {
            return;
        }
        if(start == end) {
            A[idx] = val;
            tree[node] = val;
            return;
        } else {
            int mid = (start + end) / 2;
            update(node * 2, start, mid, idx, val);
            update(node * 2 + 1, mid + 1, end, idx, val);
            tree[node] = (tree[node * 2] * tree[node * 2 + 1]) % MOD;
        }
    }

    static long query(int node, int start, int end, int left, int right) {
        if(right < start || left > end) {
            return 1;
        }
        if(left <= start && right >= end) {
            return tree[node];
        }
        int mid = (start + end) / 2;
        long L = query(node * 2, start, mid, left, right);
        long R = query(node * 2 + 1, mid + 1, end, left, right);
        return (L * R) % MOD;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new int[N];
        tree = new long[N * 4];

        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        init(1, 0, N - 1);

        for(int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            if(a == 1) {
                int idx = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                update(1, 0, N - 1, idx - 1, val);
            } else {
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                sb.append(query(1, 0, N - 1, b - 1, c - 1)).append('\n');
            }
        }

        System.out.println(sb);
    }
}