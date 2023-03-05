import java.util.*;

class Solution {
    static class Result {
        private int number;
        private int count;
        
        public Result(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }
    
    static int[] count;
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        count = new int[1000001];
        for(int i = 1; i <= 1000000; i++) {
            count[i] = -1;
        }
        
        bfs(x, y, n);
        
        return count[y];
    }
    
    static void bfs(int x, int y, int n) {
        PriorityQueue<Result> pq = new PriorityQueue<>((o1, o2) -> (o1.count - o2.count));
        count[x] = 0;
        pq.add(new Result(x, 0));
        
        while(!pq.isEmpty()) {
            Result result = pq.poll();
            int num = result.number;
            int cnt = result.count;
            
            if(num == y) break;
            
            if(num + n <= y && count[num + n] == -1) {
                pq.add(new Result(num + n, cnt + 1));
                count[num + n] = cnt + 1;
            }
            if(num * 2 <= y && count[num * 2] == -1) {
                pq.add(new Result(num * 2, cnt + 1));
                count[num * 2] = cnt + 1;
            }
            if(num * 3 <= y && count[num * 3] == -1) {
                pq.add(new Result(num * 3, cnt + 1));
                count[num * 3] = cnt + 1;
            }
        }
    }
}