class Solution {
    static int zero, one;
    static boolean[][] extracted;
    
    public int[] solution(int[][] arr) {
        int n = arr.length;
        extracted = new boolean[n][n];
        
        while(n > 1) {
            for(int i = 0; i < arr.length; i+=n) {
                for(int j = 0; j < arr.length; j+=n) {
                    if(extracted[i][j]) continue;
                    extract(arr, i, j, n);
                }
            }
            n /= 2;
        }
        
        for(int i = 0; i < arr.length; i+=n) {
            for(int j = 0; j < arr.length; j+=n) {
                if(extracted[i][j]) continue;
                if(arr[i][j] == 1) one++;
                if(arr[i][j] == 0) zero++;
            }
        }
        
        int[] answer = {zero, one};
        
        return answer;
    }
    
    static void extract(int[][] arr, int x, int y, int n) {
        int comp = arr[x][y];
        for(int i = x; i < x + n; i++) {
            for(int j = y; j < y + n; j++) {
                if(arr[i][j] != comp) return;
            }
        }
        for(int i = x; i < x + n; i++) {
            for(int j = y; j < y + n; j++) {
                extracted[i][j] = true;
            }
        }
        if(comp == 0) zero++;
        if(comp == 1) one++;
    }
}