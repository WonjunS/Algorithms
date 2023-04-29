import java.util.*;

class Solution {
    
    static String answer;
    static List<Integer> skipList;
    
    public String solution(String s, String skip, int index) {
        skipList = new ArrayList<>();
        answer = "";
        
        for(int i = 0; i < skip.length(); i++) {
            char c = skip.charAt(i);
            skipList.add((int) c); // 알파벳의 ASCII Code 값을 저장
        }
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            findChar(c, index); // 주어진 규칙에 맞게 알파벳을 변환
        }
        
        return answer;
    }
    
    private static void findChar(char c, int index) {
        int curr_idx = (int) c; // 현재 알파벳의 ASCII Code 값
        int cnt = 0; // 건너뛴 횟수(skip 제외)
        while(cnt < index) {
            curr_idx++;
            
            if(curr_idx > 122) {
                curr_idx = 97; // 이전 알파벳이 'z'였으면, 현재 알파벳을 'a'로 변경
            }
            
            if(skipList.contains(curr_idx)) { // skip에 있는 알파벳인지 확인
                continue;
            }
            
            cnt++;
        }
        
        answer += (char) curr_idx + "";
    }
}