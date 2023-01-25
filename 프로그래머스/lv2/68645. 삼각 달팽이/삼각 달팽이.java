import java.util.*;

class Solution {
    
    static int[][] board;
    
    public ArrayList<Integer> solution(int n) {
        board = new int[n + 1][n + 1];
        
        int top = 1;
        int bottom = n;
        int k = 1;
        
        while(top <= bottom) {
            fill(top, bottom, k);
            
            top = top + 2;
            bottom = bottom - 1;
            k++;
        }
        
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                answer.add(board[i][j]);
            }
        }
        
        System.out.println(board[n][n]);
        
        return answer;
    }
    
    static void fill(int top, int bottom, int k) {
        int depth = bottom - top + 1;
        
        board[top][k] = board[top - 1][k] + 1; 
        for(int i = top + 1; i <= bottom; i++) {
            board[i][k] = board[i - 1][k] + 1;
        }
        
        board[bottom][k] = board[bottom - 1][k] + 1;
        for(int i = k + 1; i <= bottom - k + 1; i++) {
            board[bottom][i] = board[bottom][i - 1] + 1;
        }
        
        for(int i = bottom - 1; i > top; i--) {
            board[i][i - k + 1] = board[i + 1][i - k + 2] + 1;
        }
    }
}