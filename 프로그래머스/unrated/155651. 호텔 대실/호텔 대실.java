import java.util.*;

class Solution {
    
    static class Booking {
        private int start;
        private int end;
        
        public Booking(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    public int solution(String[][] book_time) {
        PriorityQueue<Booking> pq = new PriorityQueue<>((o1, o2) -> (o1.start - o2.start));
        
        for(int i = 0; i < book_time.length; i++) {
            int start_h = Integer.parseInt(book_time[i][0].split(":")[0]);
            int start_m = Integer.parseInt(book_time[i][0].split(":")[1]);
            int end_h = Integer.parseInt(book_time[i][1].split(":")[0]);
            int end_m = Integer.parseInt(book_time[i][1].split(":")[1]);
            
            int start = (start_h * 60) + start_m;
            int end = (end_h * 60) + end_m;
            
            pq.add(new Booking(start, end));
        }
        
        List<Integer> end_times = new ArrayList<>();
        
        while(!pq.isEmpty()) {
            Booking b = pq.poll();
            int start = b.start;
            int end = b.end;
            
            boolean isAvailable = false;
            Collections.sort(end_times);
            for(int i = 0; i < end_times.size(); i++) {
                if(end_times.get(i) + 10 <= start) {
                    isAvailable = true;
                    end_times.set(i, end);
                    break;
                }
            }
            
            if(!isAvailable) {
                end_times.add(end);
            }
        }
        
        return end_times.size();
    }
}