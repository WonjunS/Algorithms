import java.util.*;
import java.io.*;

public class Main {

    static class Member {
        private int paper;
        private int interview;

        public Member(int paper, int interview) {
            this.paper = paper;
            this.interview = interview;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int T, N;
    static ArrayList<Member> arr;

    static void input() throws Exception {
        T = Integer.parseInt(br.readLine());
    }

    static void pro() throws Exception {
        for(int i = 1; i <= T; i++) {
            N = Integer.parseInt(br.readLine());
            arr = new ArrayList<>();
            for(int j = 1; j <= N; j++) {
                st = new StringTokenizer(br.readLine());
                int r1 = Integer.parseInt(st.nextToken());
                int r2 = Integer.parseInt(st.nextToken());
                arr.add(new Member(r1, r2));
            }
            Collections.sort(arr, new Comparator<Member>() {
                @Override
                public int compare(Member o1, Member o2) {
                    return o1.paper - o2.paper;
                }
            });

            int c = arr.get(0).interview;
            int count = 1;
            for(int j = 1; j < N; j++) {
                if(c > arr.get(j).interview) {
                    c = arr.get(j).interview;
                    count++;
                }
            }

            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception {
        input();
        pro();
    }
}