import java.util.*;

class Solution {
    
    static List<String> list;
    
    public int solution(String[] babbling) {
        list = new ArrayList<>();
        list.add("aya");
        list.add("ye");
        list.add("woo");
        list.add("ma");
        
        int answer = 0;
        
        for(String b : babbling) {
            boolean isAvailable = true;
            String prev = "";
            while(true) {
                String two = twoWords(b);
                if(two.equals("")) {
                    isAvailable = false;
                    break;
                }
                if(list.contains(two)) {
                    if(prev.equals(two)) {
                        isAvailable = false;
                        break;
                    }
                    prev = two;
                    b = b.substring(2);
                    if(b.length() == 0) break;
                    continue;
                }
                
                String three = threeWords(b);
                if(three.equals("")) {
                    isAvailable = false;
                    break;
                }
                if(list.contains(three)) {
                    if(prev.equals(three)) {
                        isAvailable = false;
                        break;
                    }
                    prev = three;
                    b = b.substring(3);
                    if(b.length() == 0) break;
                    continue;
                }
                else {
                    isAvailable = false;
                    break;
                }
            }
            
            if(isAvailable) answer++;
        }
        
        return answer;
    }
    
    static String twoWords(String str) {
        if(str.length() < 2) {
            return "";
        }
        String s = str.substring(0, 2);
        
        return s;
    }
    
    static String threeWords(String str) {
        if(str.length() < 3) {
            return "";
        }
        String s = str.substring(0, 3);
        return s;
    }
}