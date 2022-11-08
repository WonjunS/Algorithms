import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] adj;
    static boolean[] visit;
    static int answer = 0;
    
    public int solution(int n, int[][] computers) {
        int length = computers.length;
        
        adj = new ArrayList[length];
        visit = new boolean[length];
        for(int i = 0; i < length; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < length; i++) {
            for(int j = 0; j < length; j++) {
                if(computers[i][j] == 0) continue;
                else {
                    if(i == j) continue;
                    if(!adj[i].contains(j)) adj[i].add(j);
                    if(!adj[j].contains(i)) adj[j].add(i);
                }
            }
        }
        
        for(int i = 0; i < length; i++) {
            if(visit[i]) continue;
            else {
                bfs(i);
                answer++;
            }
        }
        
        return answer;
    }
    
    static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visit[n] = true;
        
        while(!q.isEmpty()) {
            int x = q.poll();
            for(int y : adj[x]) {
                if(visit[y]) continue;
                
                q.add(y);
                visit[y] = true;
            }
        }
    }
}