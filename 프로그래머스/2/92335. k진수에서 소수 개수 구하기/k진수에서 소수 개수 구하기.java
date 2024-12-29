class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        String value = getConvertedValue(n, k);
        String[] values = value.split("0+");
        for(String val : values) {
            if(isPrimeNumber(Long.parseLong(val))) answer++;
        }
        
        return answer;
    }
    
    private static String getConvertedValue(int n, int k) {
        String str = "";
        while(true) {
            if(n == 0) break;
            int v = n % k;
            str = v + str;
            n /= k;
        }
        return str;
    }
    
    private static boolean isPrimeNumber(long n) {
        if(n == 1) return false;
        if(n == 2) return true;
        for(int i = 3; i <= (int) Math.sqrt(n); i += 2) {
            if(n % i == 0) return false;
        }
        
        return true;
    }
    
}