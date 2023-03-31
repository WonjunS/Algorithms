class Solution {
    
    static int count_O, count_X;
    
    public int solution(String[] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length(); j++) {
                char c = board[i].charAt(j);
                if(c == 'O') count_O++;
                if(c == 'X') count_X++;
            }
        }
        
        // 규칙상 'X'의 개수가 'O'보다 많을수 없음
        if(count_O < count_X) {
            return 0;
        }
        
        // 'O'의 개수가 'X'의 개수보다 2개 이상 많을수 없음
        if(count_O > (count_X + 1)) {
            return 0;
        }
        
        // 'O'의 개수가 'X'의 개수가 같은 경우
        // -> 선공과 후공 모두 종료된 시점
        if(count_O == count_X) {
            // 규칙상 선공과 후공의 총 공격수가 같으면, 선공의 차례에서 게임이 끝나면 안됨
            if(isGameOver(board, 'O')) {
                return 0;
            }
            
            return 1;
        }
        
        // 'O'의 개수가 'X'의 개수보다 1개 많은 경우
        // -> 선공 종료 후 후공 대기
        if(count_O == (count_X + 1)) {
            // 규칙상 후공이 이겼을 경우, 선공과 후공의 총 공격수는 같아야함
            if(isGameOver(board, 'X')) {
                return 0;
            }
            return 1;
        }
        
        return -1;
    }
    
    // 게임이 종료되는 규칙을 만족하는지 확인하는 메서드
    static boolean isGameOver(String[] board, char sign) {
        // 1. 가로 방향 체크
        for(int i = 0; i < board.length; i++) {
            boolean isOver = true;
            for(int j = 0; j < board[i].length(); j++) {
                char c = board[i].charAt(j);
                if(c != sign) {
                    isOver = false;
                    break;
                }
            }
            
            if(isOver) {
                return true;
            }
        }
        
        // 2. 세로 방향 체크
        for(int i = 0; i < board[0].length(); i++) {
            boolean isOver = true;
            for(int j = 0; j < board.length; j++) {
                char c = board[j].charAt(i);
                if(c != sign) {
                    isOver = false;
                    break;
                }
            }
            
            if(isOver) {
                return true;
            }
        }
        
        // 3. 대각선 체크
        // (1) '\' 방향
        boolean isOver = true;
        for(int i = 0; i < board.length; i++) {
            char c = board[i].charAt(i);
            if(c != sign) {
                isOver = false;
                break;
            }
        }
        
        if(isOver) {
            return true;
        }
        
        // (2) '/' 방향
        isOver = true;
        for(int i = 0; i < board.length; i++) {
            char c = board[i].charAt(2 - i);
            if(c != sign) {
                isOver = false;
                break;
            }
        }
        
        if(isOver) {
            return true;
        }
        
        return false;
    }
}