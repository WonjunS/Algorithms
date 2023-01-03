import java.util.*;

public class Main {

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] A, ans;
    static ArrayList<Integer>[] nums;
    static ArrayList<Point> points;
    static boolean[][] appeared;

    static void search(int k) {
        if(k == points.size()) {
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    ans[i][j] = A[i][j];
                }
            }
            return;
        }

        else {
            int x = points.get(k).x;
            int y = points.get(k).y;

            int idx = (x / 3) * 3 + (y / 3);
            for (int num : nums[idx]) {
                if (!isSatisfied(x, y, num)) continue;
                A[x][y] = num;
                search(k + 1);
                A[x][y] = 0;
            }
        }
    }

    static boolean isSatisfied(int x, int y, int n) {
        for(int i = 0; i < 9; i++) {
            if(A[i][y] == n) return false;
        }
        for(int i = 0; i < 9; i++) {
            if(A[x][i] == n) return false;
        }
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                if(A[(x / 3) * 3 + i][(y / 3) * 3 + j] == n) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        A = new int[9][9];
        ans = new int[9][9];
        points = new ArrayList<>();
        appeared = new boolean[10][9];

        nums = new ArrayList[9];
        for(int i = 0; i < 9; i++) {
            nums[i] = new ArrayList<>();
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                int idx = (i / 3) * 3 + (j / 3);
                A[i][j] = sc.nextInt();
                if(A[i][j] == 0) {
                    points.add(new Point(i, j));
                    continue;
                }
                else appeared[A[i][j]][idx] = true;
            }
        }

        for(int i = 0; i < 9; i++) {
            for(int j = 1; j <= 9; j++) {
                if(!appeared[j][i]) nums[i].add(j);
            }
        }

        search(0);

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sb.append(ans[i][j]).append(' ');
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}