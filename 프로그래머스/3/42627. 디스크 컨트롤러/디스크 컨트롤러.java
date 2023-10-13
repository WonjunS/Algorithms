import java.util.*;

class Solution {
    
    private static class Task {
        private int start;
        private int time;
        
        public Task(int start, int time) {
            this.start = start;
            this.time = time;
        }
    }
    
    public int solution(int[][] jobs) {
        int N = jobs.length;
        
        Arrays.sort(jobs, (o1, o2) -> (o1[0] - o2[0]));
        
        PriorityQueue<Task> pq = new PriorityQueue<>((o1, o2) -> (o1.time - o2.time));
        
        int total = 0;
        int end = 0;
        int idx = 0;
        int count = 0;
        
        while(count < N) {
            while(idx < N && jobs[idx][0] <= end) {
                pq.add(new Task(jobs[idx][0], jobs[idx][1]));
                idx++;
            }
            
            if(pq.isEmpty()) {
                end = jobs[idx][0];
            } else {
                Task task = pq.poll();
                total += task.time + end - task.start;
                end += task.time;
                
                count++;
            }
        }
        
        return total / N;
    }
    
}