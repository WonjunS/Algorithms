class Solution {
    
    static int idx = 0;
    static int[][] answer;
    
    public int[][] solution(int n) {
        answer = new int[(int) Math.pow(2, n) - 1][2];
        
        hanoi(n, 1, 3, 2);
        
        return answer;
    }
    
    static void hanoi(int N, int start, int dest, int mid) {
        if(N == 1) {
            answer[idx++] = new int[] {start, dest};
            return;
        }
        
        hanoi(N - 1, start, mid, dest);
        
        answer[idx++] = new int[] {start, dest};
        
        hanoi(N - 1, mid, dest, start);
    }
}