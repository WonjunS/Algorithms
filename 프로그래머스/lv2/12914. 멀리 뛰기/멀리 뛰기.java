class Solution {
    
    public long solution(int n) {
        long[] Dy = new long[2001];
        Dy[1] = 1;
        Dy[2] = 2;
        for(int i = 3; i <= n; i++) {
            Dy[i] = (Dy[i - 2] + Dy[i - 1]) % 1234567;
        }
        
        return Dy[n];
    }
}