import java.util.*;
import java.io.*;

public class Main {
    
    private static class Team {
        private String teamNo;
        private int fifthScore;
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        while(T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            
            st = new StringTokenizer(br.readLine()); 
            
            int maxNo = 0;
            Map<Integer, Integer> countMap = new HashMap<>();
            Queue<Integer> q = new LinkedList<>();
            for(int i = 1; i <= N; i++) {
                int t = Integer.parseInt(st.nextToken());
                q.add(t);
                maxNo = Math.max(t, maxNo);
                
                countMap.put(t, countMap.getOrDefault(t, 0) + 1);
            }
            
            int point = 1;
            int[] counts = new int[maxNo + 1];
            int[] scores = new int[maxNo + 1];
            int[] fifthScore = new int[maxNo + 1];
            while(!q.isEmpty()) {
                int t = q.poll();
                
                if(countMap.get(t) < 6) continue;

                counts[t]++;
                
                if(counts[t] <= 4) {
                    scores[t] += point;
                }
                
                if(counts[t] == 5) {
                    fifthScore[t] = point;
                }
                
                point++;
            }
            
            int teamNo = 0;
            int min = Integer.MAX_VALUE;
            for(int i = 1; i <= maxNo; i++) {
                int score = scores[i];

                if(countMap.get(i) < 6) continue;
                
                if(score == min) {
                    if(fifthScore[teamNo] > fifthScore[i]) {
                        teamNo = i;
                    }
                }
                
                if(score < min) {
                    min = score;
                    teamNo = i;
                }
            }
            
            sb.append(teamNo).append('\n');
        }
        
        System.out.println(sb.toString());
    }
    
}