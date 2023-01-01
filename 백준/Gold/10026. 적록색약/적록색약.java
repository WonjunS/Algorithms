import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int N, red, blue, green;
    static String colour;
    static String[][] board;
    static boolean[][] visit;
    static int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new String[N][N];
        for(int i = 0; i < N; i++) {
            String s = sc.next();
            for(int j = 0; j < N; j++) {
                board[i][j] = String.valueOf(s.charAt(j));
            }
        }
    }

    static void pro() {
        // 적록색약이 아닌 사람
        red = blue = green = 0;
        visit = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visit[i][j]) continue;
                colour = board[i][j];
                bfs(i, j);
                if(colour.equals("R")) red++;
                else if(colour.equals("B")) blue++;
                else green++;
            }
        }

        sb.append(red + blue + green).append(' ');

        // 적록색약인 사람
        red = blue = green = 0;
        visit = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(visit[i][j]) continue;
                colour = board[i][j];
                bfs_(i, j);
                if(!colour.equals("B")) red++;
                else blue++;
            }
        }

        sb.append(red + blue).append('\n');

        System.out.println(sb);
    }

    static void bfs(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        visit[x][y] = true;
        q.add(x);
        q.add(y);

        while(!q.isEmpty()) {
            x = q.poll();
            y = q.poll();
            for(int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(!board[nx][ny].equals(colour)) continue;
                if(visit[nx][ny]) continue;
                q.add(nx);
                q.add(ny);
                visit[nx][ny] = true;
            }
        }
    }

    static void bfs_(int x, int y) {
        Queue<Integer> q = new LinkedList<>();
        visit[x][y] = true;
        q.add(x);
        q.add(y);

        while(!q.isEmpty()) {
            x = q.poll();
            y = q.poll();
            for(int k = 0; k < 4; k++) {
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(board[nx][ny].equals("B") && !colour.equals("B")) continue;
                if(!board[nx][ny].equals("B") && colour.equals("B")) continue;
                if(visit[nx][ny]) continue;
                q.add(nx);
                q.add(ny);
                visit[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}