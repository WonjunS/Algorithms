import java.util.*;

class Solution {
    
    static final int MAX = 98765432;
    static int[][] memo;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        init(n, fares);
        
        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    memo[i][j] = Math.min(memo[i][j], memo[i][k] + memo[k][j]);
                }
            }
        }
        
        int answer = MAX;
        for(int k = 1; k <= n; k++) {
            answer = Math.min(answer, memo[s][k] + memo[k][a] + memo[k][b]);
        }
        
        return answer;
    }
    
    static void init(int n, int[][] fares) {
        memo = new int[n + 1][n + 1];
        
        for(int i = 0; i <= n; i++) {
            for(int j = 0; j <= n; j++) {
                if(i != j) memo[i][j] = MAX;
            }
        }
        
        for(int[] fare : fares) {
            memo[fare[0]][fare[1]] = memo[fare[1]][fare[0]] = fare[2];
        }
    }
}