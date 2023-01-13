import java.util.*;
import java.io.*;

public class Main {

    static class Task {
        private int deadline;
        private int count;

        public Task(int deadline, int count) {
            this.deadline = deadline;
            this.count = count;
        }
    }

    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        ArrayList<Task> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int ramen = Integer.parseInt(st.nextToken());

            list.add(new Task(deadline, ramen));
        }
        
        Collections.sort(list, new Comparator<>() {
            @Override
            public int compare(Task t1, Task t2) {
                if(t1.deadline == t2.deadline) {
                    return t2.count - t1.count;
                }
                return t1.deadline - t2.deadline;
            }
        });

        for(Task task : list) {
            int day = pq.size();
            if(task.deadline > day) {
                pq.add(task.count);
            }
            else if(task.deadline == day) {
                if(pq.peek() < task.count) {
                    pq.poll();
                    pq.add(task.count);
                }
            }
        }
        
        int max = 0;
        for(int n : pq) max += n;

        System.out.println(max);
    }
}