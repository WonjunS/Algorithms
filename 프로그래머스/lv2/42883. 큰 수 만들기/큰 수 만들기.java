class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        int idx = 0;
        int next = 0;
        for(int i = 0; i < number.length() - k; i++) {
            int max = 0;
            
            for(int j = idx; j <= i + k; j++) {
                int curr = number.charAt(j) - '0';
                
                if(curr > max) {
                    max = curr;
                    next = j;
                    if(curr == 9) break;
                }
            }
            idx = next + 1;
            sb.append(max);
        }
        
        return sb.toString();
    }
}
