import java.util.*;

class Solution {
    public List<Integer> solution(String[] keymap, String[] targets) {
        List<Integer> answer = new ArrayList<>();
        
        Map<Character, Integer> keypad = new HashMap<>();
        for(int i = 0; i < keymap.length; i++) {
            String s = keymap[i];
            for(int j = 0; j < s.length(); j++) {
                char c = s.charAt(j);
                
                if(keypad.containsKey(c)) {
                    int prev = keypad.get(c);
                    int curr = j + 1;
                    
                    if(prev <= curr) {
                        continue;
                    } else {
                        keypad.put(c, (j + 1));
                    }
                } else {
                    keypad.put(c, (j + 1));
                }
            }
        }
        
        for(int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int total = 0;
            for(int j = 0; j < target.length(); j++) {
                char c = target.charAt(j);
                if(!keypad.containsKey(c)) {
                    total = -1;
                    break;
                } else {
                    total += keypad.get(c);
                }
            }
            
            answer.add(total);
        }
        
        return answer;
    }
}