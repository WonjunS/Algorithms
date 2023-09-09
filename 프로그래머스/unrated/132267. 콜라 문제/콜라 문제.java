class Solution {
    public int solution(int a, int b, int n) {
        int count = 0;
        
        while(true) {
            if(n < a) {
                break;
            }
            
            if(n % (a * b) == 0) {
                count += (n / a) * b;
                n /= a;
            } else {
                count += (n / a) * b;
                n = (n / a) * b + (n % a);
            }
        }
        
        return count;
    }
}