class Solution {
    
    public int solution(int n) {
        int[] Dy = new int[5005];
        
        Dy[1] = 2;
        Dy[2] = 3;
        for(int i = 3; i <= 5000; i++) {
            if(i % 2 == 0) {
                Dy[i] = Dy[i - 1] % 1000000007 + Dy[i - 2] % 1000000007;
            }
            if(i % 2 != 0) {
                Dy[i] = Dy[i - 1] * 2 % 1000000007 + Dy[i - 2] % 1000000007;
            }
            Dy[i] = Dy[i] % 1000000007;
        }
        
        int answer = Dy[n];
        
        return answer;
    }
}