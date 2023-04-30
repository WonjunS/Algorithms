class Solution {
    
    public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        
        int[][] Dy = new int[N][N];
        Dy[0][0] = triangle[0][0];
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < triangle[i].length; j++) {
                if(j == 0) {
                    Dy[i][j] = Dy[i - 1][j] + triangle[i][j];
                    continue;
                }
                if(j == triangle[i].length - 1) {
                    Dy[i][j] = Dy[i - 1][j - 1] + triangle[i][j];
                    continue;
                }
                Dy[i][j] = Math.max(Dy[i - 1][j - 1], Dy[i - 1][j]) + triangle[i][j];
            }
        }
        
        for(int i = 0; i < N; i++) {
            answer = Math.max(answer, Dy[N - 1][i]);
        }
        
        return answer;
    }
}