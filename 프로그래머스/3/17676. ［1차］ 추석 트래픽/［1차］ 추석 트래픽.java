import java.util.*;

class Solution {
    public int solution(String[] lines) {
        List<Integer> startTimes = new ArrayList<>();
        List<Integer> endTimes = new ArrayList<>();
        
        for(String line : lines) {
            String time = line.split(" ")[1];
            int hour = Integer.parseInt(time.split(":")[0]);
            int minute = Integer.parseInt(time.split(":")[1]);
            int second = Integer.parseInt((time.split(":")[2]).split("\\.")[0]);
            int millisecond = Integer.parseInt((time.split(":")[2]).split("\\.")[1]);
            
            int endTime = ((hour * 60 + minute) * 60 + second) * 1000 + millisecond;
            int duration = extractDuration(line.split(" ")[2]);
            int startTime = endTime - duration + 1;
            
            startTimes.add(startTime);
            endTimes.add(endTime);
        }
        
        int answer = 0;
        
        for(int i = 0; i < lines.length; i++) {
            int start = startTimes.get(i);
            int end = start + 1000;
            
            int count = 0;
            for(int j = 0; j < lines.length; j++) {
                if(startTimes.get(j) < end && start <= endTimes.get(j)) count++;
            }
            answer = Math.max(answer, count);
        }
        
        for(int i = 0; i < lines.length; i++) {
            int start = endTimes.get(i);
            int end = start + 1000;
            
            int count = 0;
            for(int j = 0; j < lines.length; j++) {
                if(startTimes.get(j) < end && start <= endTimes.get(j)) count++;
            }
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
    
    private static int extractDuration(String duration) {
        String str = duration.substring(0, duration.length() - 1);
        return (int) (Double.parseDouble(str) * 1000);
    }
}