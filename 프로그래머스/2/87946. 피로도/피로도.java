class Solution {
    
    private static int N, answer;
    private static int[] steps;
    private static boolean[] visit;
    
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        
        visit = new boolean[N];
        steps = new int[N];
        search(0, k, dungeons);
        
        return answer;
    }
    
    private static void search(int idx, int k, int[][] dungeons) {
        if(idx == N) {
            int amount = k;
            int cnt = 0;
            for(int i = 0; i < N; i++) {
                int step = steps[i];
                int min = dungeons[step][0];
                int cost = dungeons[step][1];
                
                if(min > amount) {
                    break;
                }
                amount -= cost;
                cnt++;
            }
            answer = Math.max(answer, cnt);
            return;
        }
        
        for(int i = 0; i < N; i++) {
            if(visit[i]) continue;
            
            visit[i] = true;
            steps[idx] = i;
            search(idx + 1, k, dungeons);
            visit[i] = false;
            steps[idx] = -1;
        }
    }
}