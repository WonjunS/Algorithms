import java.util.*;
import java.io.*;

public class Main {
    
    private static class Floor {
        private int level;
        private int count;
        
        public Floor(int level, int count) {
            this.level = level;
            this.count = count;
        }
    }
    
    private static int[] counts;
    private static int F, S, G, U, D;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        
        counts = new int[F + 1];
        for(int i = 1; i <= F; i++) {
            counts[i] = Integer.MAX_VALUE;
        }
        
        bfs();
        
        int answer = counts[G];
        if(answer == Integer.MAX_VALUE) {
            System.out.println("use the stairs");
        } else {
            System.out.println(answer);
        }
    }
    
    private static void bfs() {
        PriorityQueue<Floor> pq = new PriorityQueue<>((o1, o2) -> (o1.count - o2.count));
        pq.add(new Floor(S, 0));
        counts[S] = 0;
        
        while(!pq.isEmpty()) {
            Floor floor = pq.poll();
            
            if(counts[floor.level] != floor.count) continue;
            
            int up = floor.level + U;
            int down = floor.level - D;
            
            if(up <= F) {
                if(counts[up] > counts[floor.level] + 1) {
                    counts[up] = counts[floor.level] + 1;
                    pq.add(new Floor(up, counts[up]));
                }
            }
            
            if(down >= 1) {
                if(counts[down] > counts[floor.level] + 1) {
                    counts[down] = counts[floor.level] + 1;
                    pq.add(new Floor(down, counts[down]));
                }
            }
        }
    }
    
}