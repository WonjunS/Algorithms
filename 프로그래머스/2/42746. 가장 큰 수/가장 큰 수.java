import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        
        List<String> list = new ArrayList<>();
        for(int num : numbers) {
            String val = String.valueOf(num);
            list.add(val);
        }
        
        list.sort((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for(String str : list) {
            answer += str;
        }
        
        int idx = -1;
        for(int i = 0; i < answer.length(); i++) {
            char c = answer.charAt(i);
            if(c != '0') {
                break;
            }
            idx++;
        }
        
        if(idx > -1) {
            answer = answer.substring(idx);
        }
        
        return answer;
    }
}