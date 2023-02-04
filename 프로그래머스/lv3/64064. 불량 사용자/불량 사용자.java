import java.util.*;

class Solution {
    
    static int[] selected;
    static Set<ArrayList<String>> set;
    
    public int solution(String[] user_id, String[] banned_id) {
        selected = new int[banned_id.length + 1];
        set = new HashSet<>();
        
        recur(0, user_id.length, user_id, banned_id);
        
        return set.size();
    }
    
    static void recur(int idx, int N, String[] user_id, String[] banned_id) {
        if(idx == banned_id.length) {
            isNewCase(user_id, banned_id);
            return;
        } else {
            for(int i = 0; i < N; i++) {
                boolean isSelected = false;
                for(int j = 0; j < idx; j++) 
                    if(selected[j] == i) isSelected = true;
                
                if(isSelected) continue;
                
                selected[idx] = i;
                recur(idx + 1, N, user_id, banned_id);
                selected[idx] = 0;
            }
        }
    }
    
    static void isNewCase(String[] user_id, String[] banned_id) {
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < banned_id.length; i++) {
            String s1 = user_id[selected[i]];
            String s2 = banned_id[i];
            
            if(s1.length() != s2.length()) return;
            
            for(int j = 0; j < s1.length(); j++) {
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                
                if(c2 == '*' || c1 == c2) continue;
                if(c1 != c2) return;
            }
            
            list.add(user_id[selected[i]]);
        }
        
        Collections.sort(list);
        set.add(list);
        
        return;
    } 
}