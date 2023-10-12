import java.util.*;
import java.io.*;

public class Main {
    
    private static class Meeting {
        private int start;
        private int end;
        
        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Meeting> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.end == o2.end) {
                return o1.start - o2.start;
            }

            return o1.end - o2.end;
        });
        while(N-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            pq.add(new Meeting(x, y));
        }
        
        int last = -1;
        int answer = 0;
        while(!pq.isEmpty()) {
            Meeting m = pq.poll();
            
            int start = m.start;
            int end = m.end;

            if(start >= last) {
                last = end;
                answer++;
            }
        }
        
        System.out.println(answer);
    }
    
}