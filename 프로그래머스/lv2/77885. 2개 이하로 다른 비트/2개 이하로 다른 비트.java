import java.util.*;

class Solution {
    public ArrayList<Long> solution(long[] numbers) {
        ArrayList<Long> answer = new ArrayList<>();
        
        for(int i = 0; i < numbers.length; i++) {
            long n = numbers[i];
            
            if((int) n % 2 == 0) {
                answer.add(n + 1);
                continue;
            } else {
                String s = convertToBinary(n);
                answer.add(n + find(s));
            }
        }
        
        return answer;
    }
    
    static long find(String num) {
        int i = num.length() - 1;
        for(i = num.length() - 1; i >= 0; i--) {
            if(num.charAt(i) == '0') break;
        }
        int pow = num.length() - i - 1;
        long n = (long) Math.pow(2, pow) - (long) Math.pow(2, pow - 1);
        return n;
    }
    
    static String convertToBinary(long n) {
        String num = "";
        
        int pow = 60;
        while(n > 0) {
            if(n >= (long) Math.pow(2, pow)) {
                num = num + "1";
                n -= (long) Math.pow(2, pow);
                pow--;
                continue;
            } else {
                num = num + "0";
                pow--;
            }
        }
        
        int idx = 0;
        for(idx = 0; idx < num.length(); idx++) {
            if(num.charAt(idx) == '1') break;
        }
        
        num = num.substring(idx, num.length());
        
        return num;
    }
}