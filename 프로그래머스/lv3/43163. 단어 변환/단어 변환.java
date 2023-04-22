import java.util.*;

class Solution {
    
    static int answer, n;
    static boolean[] visit;
    static List<String> list;
    
    public int solution(String begin, String target, String[] words) {
        list = Arrays.asList(words);
        answer = Integer.MAX_VALUE;
        n = list.size();
        visit = new boolean[n];
        
        if(!list.contains(target)) {
            return 0;
        }
        
        dfs(begin, target, 0);
        
        return answer;
    }
    
    static void dfs(String curr, String target, int k) {
        if(curr.equals(target)) {
            answer = Math.min(answer, k);
            return;
        }
        for(int i = 0; i < n; i++) {
            if(visit[i]) continue;
            if(!isAvailable(curr, list.get(i))) continue;
            visit[i] = true;
            dfs(list.get(i), target, k + 1);
            visit[i] = false;
        }
    }
    
    static boolean isAvailable(String s1, String s2) {
        int cnt = 0;
        for(int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            
            if(c1 != c2) cnt++;
        }
        
        return cnt == 1;
    }
}