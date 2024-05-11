import java.util.*;
import java.io.*;

public class Main {

    private static class Lecture {
        private int no;
        private int start_time;
        private int end_time;

        public Lecture(int no, int start_time, int end_time) {
            this.no = no;
            this.start_time = start_time;
            this.end_time = end_time;
        }

        public String toString() {
            return "no = " + no + ", start_time = " + start_time + ", end_time = " + end_time;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Lecture> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1.start_time == o2.start_time) {
                return o1.end_time - o2.end_time;
            }
            return o1.start_time - o2.start_time;
        });

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int no = Integer.parseInt(st.nextToken());
            int start_time = Integer.parseInt(st.nextToken());
            int end_time = Integer.parseInt(st.nextToken());

            Lecture lecture = new Lecture(no, start_time, end_time);
            pq.add(lecture);
        }

        int cnt = 1;

        int[] endTimes = new int[N];
        while(!pq.isEmpty()) {
            Lecture lecture = pq.poll();

            boolean flag = false;
            for(int i = 0; i < cnt; i++) {
                int prev = endTimes[i];
                if(prev <= lecture.start_time) {
                    flag = true;
                    endTimes[i] = lecture.end_time;
                    break;
                }
            }
            if(!flag) {
                cnt++;
                endTimes[cnt - 1] = lecture.end_time;
            }
        }
        
        System.out.println(cnt);
    }

}