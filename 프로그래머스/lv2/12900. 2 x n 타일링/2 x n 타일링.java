class Solution {
    public int solution(int n) {
        int[] Dy = new int[n + 1];
        int mod = 1000000007;
        
        Dy[1] = 1;
        
        if(n >= 2) {
            Dy[2] = 2;
        }
        
        for(int i = 3; i <= n; i++) {
            Dy[i] = (Dy[i - 1] + Dy[i - 2]) % mod;
        }

        return Dy[n];
    }
}