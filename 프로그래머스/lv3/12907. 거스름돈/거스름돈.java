class Solution {
    
    static final int mod = 1000000007;
    static int[] Dy;
    
    public int solution(int n, int[] money) {
        Dy = new int[100001];
        Dy[0] = 1;
        for(int x : money) {
            for(int i = x; i <= n; i++) {
                Dy[i] += Dy[i - x];
            }
        }
        
        return Dy[n];
    }
}