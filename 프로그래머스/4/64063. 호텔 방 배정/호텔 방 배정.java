import java.util.*;

class Solution {
    
    private static Map<Long, Long> dict;
    
    public List<Long> solution(long k, long[] room_number) {
        List<Long> answer = new ArrayList<>();
        dict = new HashMap<>();
        for(long roomNo : room_number) {
            if(dict.containsKey(roomNo)) {
                answer.add(getRoomNumber(roomNo));
            } else {
                dict.put(roomNo, roomNo + 1);
                answer.add(roomNo);
            }
        }
        
        return answer;
    }
    
    private static long getRoomNumber(long currNo) {
        if(!dict.containsKey(currNo)) {
            dict.put(currNo, currNo + 1);
            return currNo;
        }
        long roomNo = getRoomNumber(dict.get(currNo));
        dict.put(currNo, roomNo);
        return roomNo;
    }
}