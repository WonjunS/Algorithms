import java.util.*;
import java.io.*;

public class Main {
    
    private static int totalStudents, N; // 총 학생수
    private static int[][] classroom; // 교실 자리 배치도
    private static List<Integer>[] likeStudentList; // 좋아하는 학생 목록
    private static List<Integer> order; // 자리 배정할 학생 순서
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    private static class Seat {
        private int student_no;
        private int r;
        private int c;
        private int like_count;
        private int empty_count;

        public Seat(int student_no, int r, int c, int like_count, int empty_count) {
            this.student_no = student_no;
            this.r = r;
            this.c = c;
            this.like_count = like_count;
            this.empty_count = empty_count;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        totalStudents = N * N;

        classroom = new int[N + 1][N + 1];

        likeStudentList = new ArrayList[totalStudents + 1];
        for(int i = 0; i <= totalStudents; i++) {
            likeStudentList[i] = new ArrayList<>();
        }
        
        order = new ArrayList<>();
        for(int i = 1; i <= totalStudents; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            likeStudentList[x].add(a);
            likeStudentList[x].add(b);
            likeStudentList[x].add(c);
            likeStudentList[x].add(d);

            order.add(x);
        }

        // 자리 배치
        for(int student_no : order) {
            List<Seat> availableList = new ArrayList<>();
            for(int i = 1; i <= N; i++) {
                for(int j = 1; j <= N; j++) {
                    // 이미 선점된 좌석인 경우
                    if(classroom[i][j] != 0) continue;
                    int like_count = countLikeStudents(student_no, i, j);
                    int empty_count = countEmptySeats(i, j);

                    Seat seat = new Seat(student_no, i, j, like_count, empty_count);
                    availableList.add(seat);
                }
            }

            availableList.sort((s1, s2) -> {
                if(s1.like_count == s2.like_count) {
                    if(s1.empty_count == s2.empty_count) {
                        if(s1.r == s2.r) {
                            return s1.c - s2.c;
                        }
                        return s1.r - s2.r;
                    } else {
                        return s2.empty_count - s1.empty_count;
                    }
                }
                return s2.like_count - s1.like_count;
            });

            Seat s = availableList.get(0);
            int r = s.r;
            int c = s.c;
            classroom[r][c] = student_no;
        }

        // 만족도 계산
        int total = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                int student_no = classroom[i][j];
                int like_count = countLikeStudents(student_no, i, j);
                int value;
                if(like_count == 0) {
                    value = 0;
                } else {
                    value = (int) Math.pow(10, like_count - 1);
                }
                total += value;
            }
        }

        System.out.println(total);
    }

    // 특정 좌석 주변에 비어있는 칸 체크
    private static int countEmptySeats(int x, int y) {
        int count = 0;
        for(int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            
            if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
            if(classroom[nx][ny] == 0) count++;
        }

        return count;
    }

    // 특정 자리 주변에 있는 좋아하는 학생수 체크
    private static int countLikeStudents(int student_no, int x, int y) {
        int count = 0;
        for(int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            
            if(nx < 1 || ny < 1 || nx > N || ny > N) continue;
            int like_no = classroom[nx][ny];
            if(likeStudentList[student_no].contains(like_no)) {
                count++;
            }
        }

        return count;
    }

}