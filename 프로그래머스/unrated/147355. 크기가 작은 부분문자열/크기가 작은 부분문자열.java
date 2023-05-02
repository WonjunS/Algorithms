class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        
        long P = Long.parseLong(p);
        int N = p.length();
        for(int i = 0; i <= t.length() - N; i++) {
            String num = t.substring(i, i + N);
            long value = Long.parseLong(num);
            if(P >= value) answer++;
        }
        
        return answer;
    }
}