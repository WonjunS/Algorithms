import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        while(N-- > 0) {
            int x = Integer.parseInt(br.readLine());
            
            if(x == 0) {
                if(pq.isEmpty()) sb.append("0").append('\n');
                else sb.append(pq.poll()).append('\n');
            } else {
                pq.add(x);
            }
        }
        
        System.out.println(sb);
    }
}