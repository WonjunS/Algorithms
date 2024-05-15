import java.util.*;

class Solution {
    
    private static int N, K, answer;
    private static int[] arr;
    
    private static class Person {
        private int start;
        private int duration;
        
        public Person(int start, int duration) {
            this.start = start;
            this.duration = duration;
        }
    }
    
    public int solution(int k, int n, int[][] reqs) {
        N = n;
        K = k;
        
        arr = new int[K + 1];
        
        answer = Integer.MAX_VALUE;
        
        makeCases(1, N, reqs);
        
        return answer;
    }
    
    private static void makeCases(int idx, int remain, int[][] reqs) {
        if(remain < 0) return;
        if(idx == K + 1) {
            int[] tmp = arr;
            start(tmp, reqs);
            
            return;
        }
        
        if(idx == K) {
            arr[idx] = remain;
            makeCases(idx + 1, 0, reqs);
        } else {
            for(int i = 1; i <= remain - (K - idx); i++) {
                arr[idx] = i;
                makeCases(idx + 1, remain - i, reqs);
                arr[idx] = -1;
            }
        }
        
    }
    
    private static void start(int[] counts, int[][] reqs) {
        int sum = 0;
        
        List<Person>[] list = new ArrayList[K + 1];
        for(int i = 1; i <= K; i++) {
            list[i] = new ArrayList<>();
        }
        
        for(int[] req : reqs) {
            int a = req[0];
            int b = req[1];
            int c = req[2];
            
            list[c].add(new Person(a, b));
        }
        
        for(int i = 1; i <= K; i++) {
            list[i].sort((o1, o2) -> (o1.start - o2.start));
        }
        
        for(int i = 1; i <= K; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(Person p : list[i]) {
                if(pq.size() < counts[i]) {
                    int endTime = p.start + p.duration;
                    pq.add(endTime);
                } else {
                    int time = pq.poll();
                    if(p.start < time) {
                        sum += time - p.start;
                        int endTime = time + p.duration;
                        pq.add(endTime);
                    } else {
                        int endTime = p.start + p.duration;
                        pq.add(endTime);
                    }
                }
            }
        }
        
        answer = Math.min(answer, sum);
    }
}