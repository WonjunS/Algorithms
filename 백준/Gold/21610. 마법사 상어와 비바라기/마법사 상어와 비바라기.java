import java.util.*;
import java.io.*;

public class Main {

    private static int N, M;
    private static int[][] A;
    private static boolean[][] hideCloud, cloud;
    private static int[][] dirs = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        A = new int[N + 1][N + 1];
        for(int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 1; c <= N; c++) {
                int x = Integer.parseInt(st.nextToken());
                A[r][c] = x;
            }
        }

        hideCloud = new boolean[N + 1][N + 1];
        hideCloud[N][1] = true;
        hideCloud[N][2] = true;
        hideCloud[N - 1][1] = true;
        hideCloud[N - 1][2] = true;

        cloud = new boolean[N + 1][N + 1];
        cloud[N][1] = true;
        cloud[N][2] = true;
        cloud[N - 1][1] = true;
        cloud[N - 1][2] = true;
        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            // 1. 모든 구름이 di 방향으로 si칸 이동한다.
            step1(d - 1, s);

            // 2. 각 구름에서 비가 내려 구름이 있는 칸의 바구니에 저장된 물의 양이 1 증가한다.
            step2();

            // 3. 구름이 모두 사라진다.
            step3();

            // 4. 2에서 물이 증가한 칸 (r, c)에 물복사버그 마법을 시전한다. 
            //    물복사버그 마법을 사용하면, 대각선 방향으로 거리가 1인 칸에 물이 있는 바구니의 수만큼 (r, c)에 있는 바구니의 물이 양이 증가한다.
            step4();

            // 5. 바구니에 저장된 물의 양이 2 이상인 모든 칸에 구름이 생기고, 물의 양이 2 줄어든다. 이때 구름이 생기는 칸은 3에서 구름이 사라진 칸이 아니어야 한다.
            step5();
        }

        int sum = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                sum += A[i][j];
            }
        }

        System.out.println(sum);
        
    }

    private static void step1(int idx, int s) {
        boolean[][] tmp = new boolean[N + 1][N + 1];
        for(int x = 1; x <= N; x++) {
            for(int y = 1; y <= N; y++) {
                if(hideCloud[x][y]) {
                    int nx = getPoint(dirs[idx][0] * s, x);
                    int ny = getPoint(dirs[idx][1] * s, y);
                    tmp[nx][ny] = true;
                    cloud[nx][ny] = true;
                }
            }
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                cloud[i][j] = tmp[i][j];
            }
        }
    }

    private static int getPoint(int d, int s) {
        int p = s;

        if(d == 0) {
            return p;
        }
        if(d > 0) {
            while(d-- > 0) {
                if(p == N) {
                    p = 1;
                } else {
                    p++;
                }
            }
        } else {
            while(d++ < 0) {
                if(p == 1) {
                    p = N;
                } else {
                    p--;
                }
            }
        }

        return p;
    }

    private static void step2() {
        // 구름이 있는 칸의 물의 양 1씩 증가
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                if(cloud[i][j]) {
                    A[i][j]++;
                }
            }
        }
    }

    private static void step3() {
        // 구름 상태 초기화
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                hideCloud[i][j] = cloud[i][j];
                if(cloud[i][j]) {
                    cloud[i][j] = false;
                }
            }
        }
    }

    private static void step4() {
        for(int x = 1; x <= N; x++) {
            for(int y = 1; y <= N; y++) {
                // 물이 증가한 칸인 경우
                if(hideCloud[x][y]) {
                    int cnt = 0;
                    for(int i = 1; i <= 7; i+=2) {
                        int nx = x + dirs[i][0];
                        int ny = y + dirs[i][1];

                        // 범위를 넘어가는 경우
                        if(nx > N || ny > N || nx < 1 || ny < 1) continue;
                        // 물이 없는 경우
                        if(A[nx][ny] < 1) continue;

                        cnt++;
                    }
                    A[x][y] += cnt;
                }
            }
        }
    }

    private static void step5() {
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                // 이전에 구름이 있었던 칸인 경우
                if(hideCloud[i][j]) {
                    hideCloud[i][j] = false;
                    cloud[i][j] = false;
                    continue;
                }
                hideCloud[i][j] = false;
                cloud[i][j] = false;

                // 바구니에 저장된 물의 양이 2보다 큰 경우
                if(A[i][j] >= 2) {
                    // 구름 생성
                    cloud[i][j] = true;
                    hideCloud[i][j] = true;
                    // 물의 양 2 감소
                    A[i][j] -= 2;
                }
            }
        }
    }

}