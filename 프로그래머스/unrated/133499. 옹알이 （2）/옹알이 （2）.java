import java.util.*;

class Solution {
    
    static int answer;
    static List<String> list;
    
    public int solution(String[] babbling) {
        list = new ArrayList<>(); // 발음 할 수 있는 단어들을 저장한 리스트
        list.add("aya");
        list.add("ye");
        list.add("woo");
        list.add("ma");
        
        for(String b : babbling) {
            boolean isAvailable = true; // 발음 가능한지
            String prev = ""; // 이전에 했던 발음
            while(true) {
                if(b.length() == 0) break;
                String two = twoWords(b); // ye나 ma인지 체크
                if(two.equals("IMPOSSIBLE")) { // 남은 단어가 2글자 미만이면
                    isAvailable = false;
                    break;
                }
                if(list.contains(two)) { // 발음 가능한 단어이면
                    if(prev.equals(two)) { // 이전에 발음한 단어이면
                        isAvailable = false; // 불가능 리턴하고 종료
                        break;
                    }
                    prev = two; // prev 값을 업데이트
                    b = b.substring(2); // 앞에 2글자를 잘라냄
                    continue; // 발음 가능한 두글자 찾았으면 다음으로 넘어감
                }
                
                // 두글자 중에 없는 경우
                String three = threeWords(b); // aya나 woo인 지 체크
                if(three.equals("IMPOSSIBLE")) { // 남은 단어가 3글자 미만이면
                    isAvailable = false;
                    break;
                }
                if(list.contains(three)) { // 발음 가능한 단어이면
                    if(prev.equals(three)) { // 이전에 발음한 단어이면
                        isAvailable = false;
                        break;
                    }
                    prev = three; // prev 값을 업데이트
                    b = b.substring(3); // 앞에 3글자를 잘라냄
                    continue;
                }
                // 그 외의 모든 경우
                isAvailable = false;
                break;
            }
            
            if(isAvailable) answer++; // 발음 가능한 단어면 ++
        }
        
        return answer;
    }
    
    static String twoWords(String str) {
        if(str.length() < 2) {
            return "IMPOSSIBLE";
        }
        String s = str.substring(0, 2);
        
        return s;
    }
    
    static String threeWords(String str) {
        if(str.length() < 3) {
            return "IMPOSSIBLE";
        }
        String s = str.substring(0, 3);
        return s;
    }
}