import java.util.*;

class Solution {
    
    private static int length, count;
    private static boolean[] visit;
    private static boolean[][] map;
    
    public int solution(int n, int[][] wires) {
        int answer = 100;
        length = n;
        map = new boolean[n + 1][n + 1];
        
        for(int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            
            map[v1][v2] = true;
            map[v2][v1] = true;
        }

        for(int[] wire : wires) {
            visit = new boolean[n + 1];
            
            int v1 = wire[0];
            int v2 = wire[1];
            
            map[v1][v2] = false;
            map[v2][v1] = false;
            
            count = 0;
            search(v1);
            int a = count;
            
            count = 0;
            search(v2);
            int b = count;
            
            int diff = Math.abs(a - b);
            
            answer = Math.min(answer, diff);
            
            map[v1][v2] = true;
            map[v2][v1] = true;
        }
        
        return answer;
    }
    
    private static void search(int x) {
        visit[x] = true;
        count++;
        
        for(int i = 1; i <= length; i++) {
            if(visit[i] || x == i) continue;
            if(map[x][i] == true) {
                search(i);
            }
        }
    }
}