import java.util.*;
import java.io.*;

public class Main {

    private static class Lecture {
        private int s;
        private int t;

        public Lecture(int s, int t) {
            this.s = s;
            this.t = t;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        List<Lecture> lectureList = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            Lecture lecture = new Lecture(s, t);
            lectureList.add(lecture);
        }

        lectureList.sort((o1, o2) -> {
            if(o1.s == o2.s) {
                return o1.t - o2.t;
            }
            return o1.s - o2.s;
        });

        int size = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for(Lecture lecture : lectureList) {
            if(pq.isEmpty()) {
                pq.add(lecture.t);
            } else {
                int end = pq.peek();
                if(lecture.s >= end) {
                    pq.poll();
                    pq.add(lecture.t);
                } else {
                    pq.add(lecture.t);
                }
            }

            size = Math.max(size, pq.size());
        }

        System.out.println(size);
    }

}