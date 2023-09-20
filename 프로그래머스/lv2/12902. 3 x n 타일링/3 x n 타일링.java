class Solution {
    
    private static final int MOD = 1000000007;
    
    public int solution(int n) {
        int[] DP = new int[n + 1];
        
        DP[1] = 2;
        DP[2] = 3;
        for(int i = 3; i <= n; i++) {
            if(i % 2 == 0) {
                DP[i] = DP[i - 1] % MOD + DP[i - 2] % MOD;
            } else {
                DP[i] = DP[i - 1] * 2 % MOD + DP[i - 2] % MOD;
            }
            DP[i] = DP[i] % MOD;
        }
        
        return DP[n];
    }
}