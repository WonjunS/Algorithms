import java.util.*;

class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        Arrays.sort(wallet);
        Arrays.sort(bill);
        while(true) {
            if(checkBillSize(wallet, bill)) {
                break;
            }
            
            bill[1] = bill[1] / 2;
            Arrays.sort(bill);
            
            answer++;
        }
        
        return answer;
    }
    
    private static boolean checkBillSize(int[] wallet, int[] bill) {
        return wallet[1] >= bill[1] && wallet[0] >= bill[0];
    }
}