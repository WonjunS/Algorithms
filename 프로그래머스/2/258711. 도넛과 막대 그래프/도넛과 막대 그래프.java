import java.util.*;

class Solution {
    
    private static int N;
    private static int[] answer;
    private static List<Integer>[] in, out;
    
    public int[] solution(int[][] edges) {
        for(int i = 0; i < edges.length; i++) {
            N = Math.max(N, Math.max(edges[i][0], edges[i][1]));
        }
        
        in = new ArrayList[N + 1];
        out = new ArrayList[N + 1];
        
        for(int i = 1; i <= N; i++) { 
            in[i] = new ArrayList<>();
            out[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < edges.length; i++) {
            int from = edges[i][0];
            int to = edges[i][1];
            
            in[to].add(from);
            out[from].add(to);
        }
        
        answer = new int[4];
        
        for(int i = 1; i <= N; i++) {
            if(in[i].size() == 0 && out[i].size() >= 2) {
                answer[0] = i;
            }
            
            if(out[i].size() == 0) {
                answer[2]++;
            }
            
            if(in[i].size() >= 2 && out[i].size() == 2) {
                answer[3]++;
            }
        }
        
        answer[1] = out[answer[0]].size() - (answer[2] + answer[3]);
        
        return answer;
    }
    
}