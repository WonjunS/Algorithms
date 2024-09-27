class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        
        int length = parseTextToTime(video_len);
        int curr = parseTextToTime(pos);
        int start = parseTextToTime(op_start);
        int end = parseTextToTime(op_end);
        
        for(String command : commands) {
            if(command.equals("prev")) {
                curr = Math.max(curr - 10, 0);
                
                if(curr <= end && curr >= start) curr = end;
            } else {
                if(curr > length - 10) {
                    curr = length;
                    continue;
                }
                
                if(curr >= start && curr <= end) {
                    curr = end;
                }
                
                curr = curr + 10;
                
                if(curr >= start && curr <= end) {
                    curr = end;
                }
            }
        }
        
        String mm = (curr / 60) + "";
        String ss = (curr % 60) + "";
        
        if(mm.length() < 2) mm = "0" + mm;
        if(ss.length() < 2) ss = "0" + ss;
        
        return mm + ":" + ss;
    }
    
    private static int parseTextToTime(String str) {
        String[] arr = str.split(":");
        int mm = Integer.parseInt(arr[0]);
        int ss = Integer.parseInt(arr[1]);
        
        return mm * 60 + ss;
    }
}