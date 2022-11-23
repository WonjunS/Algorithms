import java.util.*;

class Solution {
    public String solution(String play_time, String adv_time, String[] logs) {
        int best = 0;
        int playTime = strToInt(play_time);
        int advTime = strToInt(adv_time);
        int[] total = new int[playTime + 1];
        
        for(String log : logs) {
            String[] str = log.split("-");
            int start = strToInt(str[0]);
            int end = strToInt(str[1]);
            
            for(int i = start; i < end; i++) {
                total[i]++;
            }
        }
        
        long max = 0;
        for(int i = 1; i < advTime; i++) {
            max += total[i];
        }
        
        long now = max;
        for(int i = 0, j = advTime; j < playTime; i++, j++) {
            now = now - total[i] + total[j];
            if(now > max) {
                max = now;
                best = i + 1;
            }
        }
        
        String answer = intToStr(best);
        
        return answer;
    }
    
    static int strToInt(String time) {
        String[] str = time.split(":");
        int h = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);
        int s = Integer.parseInt(str[2]);
        
        return (h * 3600) + (m * 60) + s;
    }
    
    static String intToStr(int time) {
        String h = ((time / 3600) > 9) ? (time / 3600) + "" : "0" + time / 3600;
        time %= 3600;
        String m = ((time / 60) > 9) ? (time / 60) + "" : "0" + time / 60;
        time %= 60;
        String s = (time > 9) ? time + "" : "0" + time;
        String result = h + ":" + m + ":" + s;
        
        return result;
    }
}