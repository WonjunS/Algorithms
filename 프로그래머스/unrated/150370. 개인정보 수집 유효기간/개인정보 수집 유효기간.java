import java.util.*;

class Solution {
    
    static int t_year, t_month, t_day;
    static List<Integer> answer;
    static Map<String, Integer> termsList;
    
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        answer = new ArrayList<>();
        termsList = new HashMap<>();
        for(String term : terms) {
            String[] str = term.split(" ");
            String type = str[0];
            int length = Integer.parseInt(str[1]);
            termsList.put(type, length);
        }
        
        t_year = Integer.parseInt(today.split("\\.")[0]);
        t_month = Integer.parseInt(today.split("\\.")[1]);
        t_day = Integer.parseInt(today.split("\\.")[2]);
        
        for(int i = 0; i < privacies.length; i++) {
            String[] str = privacies[i].split(" ");
            String type = str[1];
            
            int year = Integer.parseInt(str[0].split("\\.")[0]);
            int month = Integer.parseInt(str[0].split("\\.")[1]);
            int day = Integer.parseInt(str[0].split("\\.")[2]);
            
            int length = termsList.get(type);
            
            if(month + length > 12) {
                // 수집일자가 1일이면 일은 28일로 바꾸고, (n - 1)개월만 더해야 함
                if(day == 1) {
                    year = year + (month + length - 1) / 12;
                    month = (month + length - 1) % 12;
                    day = 28;
                } else {
                    year = year + (month + length) / 12;
                    month = (month + length) % 12;
                    day = day - 1;
                }
            } else {
                if(day == 1) {
                    month = month + length - 1;
                    day = 28;
                } else {
                    month = month + length;
                    day = day - 1;
                }
            }
            
            // ex) 2020년 6월 5일에 18개월 후면 2021년 12월 4일이 되야함
            // 위에꺼 그대로 하면 2022년 0월 4일로 나옴
            if(month == 0) {
                year -= 1;
                month = 12;
            }
            
            // 오늘 날짜 > 만료 일자이면 answer에 추가
            if(isExpired(year, month, day)) {
                answer.add(i + 1);
            }
        }
        
        return answer;
    }
    
    private static boolean isExpired(int year, int month, int day) {
        // 연도 비교
        if(year < t_year) {
            return true;
        } else {
            // 연도 같으면 월 비교
            if(year == t_year) {
                if(month < t_month) {
                    return true;
                }
                // 월도 같으면 일 비교
                if(month == t_month) {
                    if(day < t_day) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}