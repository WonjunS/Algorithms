import java.util.*;

class Solution {
    public List<String> solution(String[] s) {
        List<String> answer = new ArrayList<>();
        for(int i = 0; i < s.length; i++) {
            int index = 0;
            String tmp = s[i];
            int sp = 0;
            StringBuilder sb2 = new StringBuilder(); // "110"을 저장
            char[] stack = new char[tmp.length()];
            while(true) {
                if(sp >= 3)
                {
                    int end = sp - 1;
                    if(stack[end] == '0' && stack[end - 1] == '1' && stack[end - 2] == '1')
                    {
                        sp -= 3;
                        sb2.append("110");
                    }
                    else if(index >= tmp.length()) break;
                    else stack[sp++] = tmp.charAt(index++);
                }
                else if(index >= tmp.length()) break; // 인덱스가 문자열 길이보다 큰 경우
                else stack[sp++] = tmp.charAt(index++);
            }
            tmp = new String(stack).substring(0, sp);
            
            StringBuilder sb = new StringBuilder();
            int idx = tmp.length(); // 첫번째 0의 인덱스
            boolean findZero = false; // 남은 문자열에 0이 있는지 여부
            while(idx > 0) {
                idx--;
                if(tmp.charAt(idx) == '0') {
                    findZero = true;
                    break;
                }
            }
            
            // "110"을 제외한 문자열 길이가 0인 경우
            if(tmp.length() == 0) {
                sb.append(sb2.toString()); // "110" 반복
            } 
            else {
                // 문자열에 0이 없는 경우
                if(findZero == false) {
                    sb.append(sb2.toString()); // "110" 반복
                    sb.append(tmp.substring(idx)); // 남은 문자열
                } 
                else {
                    sb.append(tmp.substring(0, idx + 1)); // 0과 그 앞의 문자열
                    sb.append(sb2.toString()); // "110" 반복
                    if(idx < tmp.length() - 1) sb.append(tmp.substring(idx + 1)); // 0 뒤에 있던 문자열
                }
            }
            answer.add(sb.toString());
        }
        
        return answer;
    }
}