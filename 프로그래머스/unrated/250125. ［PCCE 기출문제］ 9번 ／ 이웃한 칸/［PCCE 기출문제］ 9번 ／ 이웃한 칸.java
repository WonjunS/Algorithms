class Solution {
    
    private static int[] dh = { 0, 1, -1, 0 };
    private static int[] dw = { 1, 0, 0, -1 };
    
    private static int answer;
    
    public int solution(String[][] board, int h, int w) {
        int N = board.length;
        
        for(int i = 0; i < 4; i++) {
            int nh = h + dh[i];
            int nw = w + dw[i];
            
            if(nh < 0 || nw < 0 || nh >= N || nw >= N) {
                continue;
            }
            
            answer = (board[h][w].equals(board[nh][nw])) ? answer += 1 : answer;
        }
        
        return answer;
    }
}