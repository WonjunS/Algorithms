import java.util.*;
import java.io.*;

public class Main {
    
    static StringTokenizer st;
    
    static int N, ans;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> q1 = new PriorityQueue<Integer>(Comparator.reverseOrder());
        PriorityQueue<Integer> q2 = new PriorityQueue<Integer>();
        
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int x = Integer.parseInt(st.nextToken());
                if(q1.size() < N) {
                    q1.add(x);
                    q2.add(x);
                    continue;
                } else {
                    int last = q2.peek();
                    if(last >= x) continue;
                    else {
                        q2.poll();
                        q1.remove(last);
                        q1.add(x);
                        q2.add(x);
                    }
                }
            }
        }
        System.out.println(q2.peek());
    }
}