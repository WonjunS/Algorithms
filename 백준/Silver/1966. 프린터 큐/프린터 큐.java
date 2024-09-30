import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] priorities = new int[N];
            int[] ranks = new int[N];
            Queue<Integer> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                priorities[i] = p;
                q.add(i);
            }

            int rank = 1;
            while(!q.isEmpty()) {
                int curr = q.poll();

                boolean flag = true;
                Queue<Integer> temp_q = new LinkedList<>();
                while(!q.isEmpty()) {
                    int comp = q.poll();
                    if(priorities[comp] > priorities[curr]) {
                        flag = false;
                    }
                    temp_q.add(comp);
                }

                while(!temp_q.isEmpty()) {
                    q.add(temp_q.poll());
                }

                if(flag) {
                    ranks[curr] = rank++;
                } else {
                    q.add(curr);
                }
            }

            sb.append(ranks[M]).append('\n');
        }

        System.out.println(sb.toString());
    }

}