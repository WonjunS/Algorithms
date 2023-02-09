import java.util.*;

class Solution {
    
    static List<Integer> answer;
    static Map<String, Integer> map;
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        answer = new ArrayList<>();
        map = new HashMap<>();
        
        String[] str_t = today.split("\\.");
        int year = Integer.parseInt(str_t[0]);
        int month = Integer.parseInt(str_t[1]);
        int day = Integer.parseInt(str_t[2]);
        
        for(int i = 0; i < terms.length; i++) {
            String[] str = terms[i].split(" ");
            String type = str[0];
            int term = Integer.parseInt(str[1]);
            
            map.put(type, term);
        }
        
        for(int i = 0; i < privacies.length; i++) {
            String[] s = privacies[i].split(" ");
            String type = s[1];
            
            String[] str = s[0].split("\\.");
            int y = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int d = Integer.parseInt(str[2]);
            
            int term = map.get(type);
            int expired_y, expired_m, expired_d;
            if(m + term > 12) {
                expired_y = (m + term) / 12 + y;
                if(d == 1) {
                    expired_m = ((m + term) % 12) - 1;
                    if(expired_m == 0) {
                        expired_m = 12;
                        expired_y -= 1;
                    }
                    expired_d = 28;
                } else {
                    expired_m = (m + term) % 12;
                    if(expired_m == 0) {
                        expired_m = 12;
                        expired_y -= 1;
                    }
                    expired_d = d - 1;
                }
            } else {
                expired_y = y;
                if(d == 1) {
                    expired_m = m + term - 1;
                    expired_d = 28;
                } else {
                    expired_m = m + term;
                    expired_d = d - 1;
                }
            }
            
            if(year > expired_y) {
                answer.add(i + 1);
                continue;
            }
            if(year == expired_y) {
                if(month > expired_m) {
                    answer.add(i + 1);
                    continue;
                }
                if(month == expired_m) {
                    if(day > expired_d) {
                        answer.add(i + 1);
                        continue;
                    }
                }
            }
        }
        
        return answer;
    }
}