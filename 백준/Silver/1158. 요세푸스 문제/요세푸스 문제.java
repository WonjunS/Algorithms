import java.util.*;
import java.io.*;

public class Main {

    private static int N, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder();
        sb.append("<");
        while(q.size() > 1) {
            for(int i = 1; i < K; i++) {
                int n = q.poll();
                q.add(n);
            }
            sb.append(q.poll() + ", ");
        }
        sb.append(q.poll());
        sb.append(">");

        System.out.println(sb.toString());
    }

}