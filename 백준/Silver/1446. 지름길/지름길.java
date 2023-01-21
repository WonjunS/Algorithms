import java.util.*;
import java.io.*;

public class Main {

    static class Course {
        private int from;
        private int to;
        private int dist;

        public Course(int from, int to, int dist) {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }
    }

    static int N, D;
    static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Course> pq = new PriorityQueue<>(new Comparator<Course>() {
            @Override
            public int compare(Course o1, Course o2) {
                if(o1.to == o2.to) {
                    return o1.from - o2.from;
                }
                return o1.to - o2.to;
            }
        });
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        A = new int[10001];
        for(int i = 1; i <= 10000; i++) A[i] = i;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());

            pq.offer(new Course(from, to, dist));
        }

        for(int i = 0; i < N; i++) {
            Course course = pq.poll();
            int from = course.from;
            int to = course.to;
            int dist = course.dist;

            if(A[to] > A[from] + dist) {
                A[to] = A[from] + dist;
                for(int j = to + 1; j <= 10000; j++) {
                    A[j] = A[to] + (j - to);
                }
            }
        }

        System.out.println(A[D]);
    }
}