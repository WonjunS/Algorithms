class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();
        
        int idx;
        int move = length - 1;
        
        for(int i = 0; i < length; i++) {
           answer += Math.min('Z' - name.charAt(i) + 1, name.charAt(i) - 'A');
            
            idx = i + 1;
            while(idx < length && name.charAt(idx) == 'A') {
                idx++;
            }
            
            move = Math.min(move, i * 2 + length - idx);
            move = Math.min(move, (length - idx) * 2 + i);
        }
        
        return answer + move;
    }
}