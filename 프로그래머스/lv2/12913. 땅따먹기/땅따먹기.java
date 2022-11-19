class Solution {
    
    int solution(int[][] land) {
        int n = land.length;
        int[][] Dy = new int[n + 1][4];
        
        for(int i = 0; i < land.length; i++) {
            Dy[i + 1][0] = Math.max(Math.max(Dy[i][1], Dy[i][2]), Dy[i][3]) + land[i][0];
            Dy[i + 1][1] = Math.max(Math.max(Dy[i][0], Dy[i][2]), Dy[i][3]) + land[i][1];
            Dy[i + 1][2] = Math.max(Math.max(Dy[i][0], Dy[i][1]), Dy[i][3]) + land[i][2];
            Dy[i + 1][3] = Math.max(Math.max(Dy[i][0], Dy[i][1]), Dy[i][2]) + land[i][3];
        }
        
        int answer = Math.max(Math.max(Dy[n][0], Dy[n][1]), Math.max(Dy[n][2], Dy[n][3]));
        
        return answer;
    }
}