import java.util.*;

class Solution {
    
    static int best = Integer.MAX_VALUE;
    static ArrayList<String> list;
    
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        list = new ArrayList<>();
        
        int idx = 0;
        for(idx = 0; idx < words.length; idx++) {
            if(words[idx].equals(target)) break;
        }
        if(idx == words.length) return 0;
        
        dfs(words, begin, target);
        
        return best;
    }
    
    static void dfs(String[] words, String curr, String target) {
        if(curr.equals(target)) {
            best = Math.min(list.size(), best);
            return;
        }
        for(int i = 0; i < words.length; i++) {
            if(words[i].equals(curr)) continue;
            if(list.contains(words[i])) continue;
            if(!isAvailable(words[i], curr)) continue;
            
            System.out.println(list);
            list.add(words[i]);
            dfs(words, words[i], target);
            list.remove(words[i]);
        }
    }
    
    static boolean isAvailable(String curr, String prev) {
        for(int i = 0; i < curr.length(); i++) {
            String s1 = curr.substring(0, i) + curr.substring(i + 1, curr.length());
            String s2 = prev.substring(0, i) + prev.substring(i + 1, prev.length());
            if(s1.equals(s2)) return true;
        }
        return false;
    }
}