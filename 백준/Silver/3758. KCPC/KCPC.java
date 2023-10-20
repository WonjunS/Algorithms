import java.util.*;
import java.io.*;

public class Main {
    
    private static class Submission {
        private int idx;
        private int score;
        private int count;
        private int time;
        
        public Submission(int score, int count, int time) {
            this.score = score;
            this.count = count;
            this.time = time;
        }
        
        public Submission(int idx, int score, int count, int time) {
            this.idx = idx;
            this.score = score;
            this.count = count;
            this.time = time;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            
            Submission[][] subs = new Submission[n][k];
            for(int a = 0; a < m; a++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                
                if(subs[i - 1][j - 1] == null) {
                    subs[i - 1][j - 1] = new Submission(s, 1, a);
                    continue;
                } else {
                    Submission prev = subs[i - 1][j - 1];
                    Submission newSub = new Submission(
                        Math.max(prev.score, s),
                        prev.count + 1,
                        a
                    );
                    
                    subs[i - 1][j - 1] = newSub;
                }
            }
            
            PriorityQueue<Submission> pq = new PriorityQueue<>((o1, o2) -> {
                if(o1.score == o2.score) {
                    if(o1.count == o2.count) {
                        return o1.time - o2.time;
                    }
                    return o1.count - o2.count;
                }
                return o2.score - o1.score;
            });
            
            for(int i = 0; i < n; i++) {
                int total_score = 0;
                int total_count = 0;
                int last_submission = 0;
                for(int j = 0; j < k; j++) {
                    Submission s = subs[i][j];
                    
                    if(s == null) {
                        continue;
                    }
                    
                    total_score += s.score;
                    total_count += s.count;
                    last_submission = Math.max(last_submission, s.time);
                }
                
                pq.add(new Submission(i + 1, total_score, total_count, last_submission));
            }
            
            for(int i = 1; i <= n; i++) {
                Submission s = pq.poll();
                
                if(s.idx == t) {
                    sb.append(i).append('\n');
                    break;
                }
            }
        }
        
        System.out.println(sb.toString());
    }
    
}