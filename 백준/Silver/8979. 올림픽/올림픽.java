import java.util.*;
import java.io.*;

public class Main {
    
    private static class Country {
        private int cno;
        private int gold;
        private int silver;
        private int bronze;
        
        public Country(int cno, int gold, int silver, int bronze) {
            this.cno = cno;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        PriorityQueue<Country> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.gold != o2.gold) {
                return o2.gold - o1.gold;
            }
            if(o1.gold == o2.gold) {
                return o2.silver - o1.silver;
            }
            if(o1.silver == o2.silver) {
                return o2.bronze - o1.bronze;
            }
            return o2.gold - o1.gold;
        });
        
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int n = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            pq.add(new Country(n, g, s, b));
        }

        int rank = 1;
        int idx = 1;
        Country prev = null;
        while(!pq.isEmpty()) {
            Country curr = pq.poll();

            if(prev != null) {
                if(curr.gold == prev.gold && curr.silver == prev.silver && curr.bronze == prev.bronze) {}
                else rank = idx;
            }

            if(curr.cno == K) {
                System.out.println(rank);
                break;
            }

            prev = curr;
            idx++;
        }

    }
    
}