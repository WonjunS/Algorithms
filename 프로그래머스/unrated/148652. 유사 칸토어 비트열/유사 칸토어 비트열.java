class Solution {
    
    static int answer;
    
    public int solution(int n, long l, long r) {
        for(long i = l; i <= r; i++) {
            long x = (i - 1) % 5;
            if(x == 2) {
                continue;
            }
            long temp = i - 1;
            while(true) {
                if(temp % 5 == 2) {
                    break;
                }
                
                if(temp < 5) {
                    answer++;
                    break;
                }
                
                temp /= 5;
            }
        }
        
        return answer;
    }
    
}