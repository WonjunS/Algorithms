import java.util.*;
import java.io.*;

public class Main {

    static class Pair {
        private int first;
        private int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M;
    static int[] arr, min_tree, max_tree;

    static void init(int node, int start, int end) {
        if(start == end) {
            min_tree[node] = max_tree[node] = arr[start];
            return;
        }
        init(node * 2, start, (start + end) / 2);
        init(node * 2 + 1, (start + end) / 2 + 1, end);
        min_tree[node] = Math.min(min_tree[node * 2], min_tree[node * 2 + 1]);
        max_tree[node] = Math.max(max_tree[node * 2], max_tree[node * 2 + 1]);
        return;
    }

    static Pair find(int node, int a, int b, int left, int right) {
        if(left > b || right < a) {
            return new Pair(Integer.MAX_VALUE, 0);
        }
        if(a <= left && right <= b) {
            return new Pair(min_tree[node], max_tree[node]);
        }
        Pair l, r;
        l = find(node * 2, a, b, left, (left + right) / 2);
        r = find(node * 2 + 1, a, b, (left + right) / 2 + 1, right);
        return new Pair(Math.min(l.first, r.first), Math.max(l.second, r.second));
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int ts = 1 << (int) (Math.ceil(Math.log(N) / Math.log(2)) + 1);
        min_tree = new int[ts];
        max_tree = new int[ts];

        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, 0, N - 1);

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Pair answer = find(1, a - 1, b - 1, 0, N - 1);
            sb.append(answer.first).append(' ').append(answer.second).append('\n');
        }

        System.out.println(sb);
    }
}