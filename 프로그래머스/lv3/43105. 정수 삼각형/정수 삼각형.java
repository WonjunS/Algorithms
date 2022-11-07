class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int length = triangle.length;
        int[][] Dy = new int[length][length];
        
        
        Dy[0][0] = triangle[0][0];
        if(triangle.length == 1) return Dy[0][0];
        
        Dy[1][0] = triangle[1][0] + Dy[0][0];
        Dy[1][1] = triangle[1][1] + Dy[0][0];
        
        if(triangle.length == 2) return Math.max(Dy[1][0], Dy[1][1]);
        
        for(int i = 2; i < triangle.length; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if(j == 0) {
                    Dy[i][j] = triangle[i][j] + Dy[i - 1][0];
                    continue;
                }
                if(j == triangle[i].length - 1) {
                    Dy[i][j] = triangle[i][j] + Dy[i - 1][j - 1];
                    continue;
                }
                else {
                    Dy[i][j] = triangle[i][j] + Math.max(Dy[i - 1][j - 1], Dy[i - 1][j]);
                }
            }
        }
        
        for(int i = 0; i < length; i++) {
            answer = Math.max(answer, Dy[length - 1][i]);
        }
        
        return answer;
    }
}