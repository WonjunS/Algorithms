import java.util.*;

class Solution {
    
    private static class Path {
        private int point;
        private int length;
        
        public Path(int point, int length) {
            this.point = point;
            this.length = length;
        }
    }
    
    private static List<Path>[] pathList;
    private static int idx, min;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        pathList = new ArrayList[50_001];
        for(int i = 1; i <= n; i++) {
            pathList[i] = new ArrayList<>();
        }
        
        for(int[] path : paths) {
            pathList[path[0]].add(new Path(path[1], path[2]));
            pathList[path[1]].add(new Path(path[0], path[2]));
        }
        
        Arrays.sort(summits);
        
        bfs(n, gates, summits);
        
        int[] answer = { idx, min };
        
        return answer;
    }
    
    private static void bfs(int n, int[] gates, int[] summits) {
        PriorityQueue<Path> pq = new PriorityQueue<>((o1, o2) -> (o1.length - o2.length));
        
        int[] D = new int[n + 1];
        Arrays.fill(D, Integer.MAX_VALUE);
        
        for(int gate : gates) {
            pq.add(new Path(gate, 0));
        }
        
        boolean[] visit = new boolean[n + 1];
        
        while(!pq.isEmpty()) {
            Path curr = pq.poll();
            
            int curr_idx = curr.point;
            int curr_len = curr.length;
            
            if(visit[curr_idx]) continue;
            
            visit[curr_idx] = true;
            
            for(Path p : pathList[curr_idx]) {
                int next_idx = p.point;
                int next_len = p.length;
                
                if(D[next_idx] > Math.max(curr_len, next_len)) {
                    D[next_idx] = Math.max(curr_len, next_len);
                    if(isSummit(summits, next_idx)) continue;
                    pq.add(new Path(next_idx, D[next_idx]));
                }
            }
        }
        
        min = Integer.MAX_VALUE;
        for(int i = 0; i < summits.length; i++) {
            if(min > D[summits[i]]) {
                min = D[summits[i]];
                idx = summits[i];
            }
        }
    }
    
    private static boolean isSummit(int[] summits, int n) {
        for(int summit : summits) {
            if(summit == n) {
                return true;
            }
        }
        
        return false;
    }
    
}