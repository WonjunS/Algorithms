class Solution {
    
    private static int answer, length, N, M;
    private static boolean[][][] visit;
    
    public int solution(int[][] info, int n, int m) {
        answer = -1;
        length = info.length;
        N = n;
        M = m;
        visit = new boolean[length][N + 1][M + 1];
        
        dfs(info, 0, 0, 0);
        
        return answer;
    }
    
    private static void dfs(int[][] info, int idx, int a, int b) {
        if(a >= N || b >= M) {
            return;
        }
        
        if(idx == length) {
            if(answer == -1) {
                answer = a;
            } else {
                answer = Math.min(answer, a);
            }
            return;
        }
        
        if(visit[idx][a][b]) return;
        visit[idx][a][b] = true;
        
        dfs(info, idx + 1, a + info[idx][0], b);
        dfs(info, idx + 1, a, b + info[idx][1]);
    }
}