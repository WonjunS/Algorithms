class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char x = s.charAt(0);
        int cnt = 1;
        int subCnt = 0;
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if(x == ' ') {
                x = c;
                cnt = 0;
                subCnt = 0;
            }
            if(c == x) {
                cnt++;
            }
            if(c != x) {
                subCnt++;
            }
            if(cnt == subCnt) {
                answer++;
                x = ' ';
            }
        }
        
        if(x != ' ') {
            answer++;
        }
        
        return answer;
    }
}