import java.util.*;
import java.io.*;

public class Main {

    static StringTokenizer st;

    static int N, M, K;
    static long[] A, tree;

    static void init(int node, int start, int end) {
        if(start == end) {
            tree[node] = A[start];
            return;
        }
        else {
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
        }
        else {
            update(node * 2, start, (start + end) / 2, idx, val);
            update(node * 2 + 1, (start + end) / 2 + 1, end, idx, val);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        A = new long[N];
        tree = new long[N * 4];

        for(int i = 0; i < N; i++) {
            A[i] = Long.parseLong(br.readLine());
        }

        init(1, 0, N - 1);

        for(int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            if(a == 1) {
                int idx = Integer.parseInt(st.nextToken());
                long val = Long.parseLong(st.nextToken());
                update(1, 0, N - 1, idx - 1, val);
            } else {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                sb.append(query(1, 0, N - 1, left - 1, right - 1)).append('\n');
            }
        }
        System.out.println(sb);
    }
}