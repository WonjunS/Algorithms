class Solution {
    
    static int count, total;
    
    private static String convertToBinary(int n) {
        int d = n / 2;
        int r = n % 2;
        if(d == 0) {
            return r + "";
        }
        return convertToBinary(d) + "" + r;
    }
    
    private static int eraseZero(String s) {
        int subTotal = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '0') subTotal++;
        }
        
        total += subTotal;
        
        return s.length() - subTotal;
    }
    
    public int[] solution(String s) {
        while(true) {
            if(s.equals("1")) {
                break;
            }
            int n = eraseZero(s);
            s = convertToBinary(n);
            count++;
        }
        
        int[] answer = {count, total};
        
        return answer;
    }
}