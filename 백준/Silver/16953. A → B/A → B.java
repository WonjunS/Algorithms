import java.util.*;
import java.io.*;

public class Main {
    
    private static class Result {
        private long value;
        private int count;
        
        public Result(long value, int count) {
            this.value = value;
            this.count = count;
        }
    }
    
    private static long A, B;
    private static int answer = -1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());
        
        bfs();
        
        System.out.println(answer);
    }
    
    private static void bfs() {
        PriorityQueue<Result> pq = new PriorityQueue<>((o1, o2) -> (o1.count - o2.count));
        pq.add(new Result(A, 0));
        
        while(!pq.isEmpty()) {
            Result r = pq.poll();
            
            if(r.value == B) {
                answer = r.count + 1;
                return ;
            }
            
            // 1. 2를 곱하는 연산
            if(r.value * 2 <= B) {
                pq.add(new Result(r.value * 2, r.count + 1));
            }
            
            // 2. 오른쪽에 1을 추가
            long x = appendOne(String.valueOf(r.value));
            if(x <= B) {
                pq.add(new Result(x, r.count + 1));
            }
        }
    }
    
    private static long appendOne(String s) {
        return Long.parseLong(s + "1");
    }
    
}