import java.util.*;
import java.io.*;

public class Main {

    private static int R, C, T, air_x1, air_x2;
    private static int[][] map, temp_arr;
    private static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private static boolean[][] spreadable;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        temp_arr = new int[R][C];
        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < C; j++) {
                int x = Integer.parseInt(st.nextToken());
                map[i][j] = x;

                if(x == -1) {
                    if(air_x1 > 0) {
                        air_x2 = i;
                    } else {
                        air_x1 = i;
                    }
                }
            }
        }

        for(int i = 1; i <= T; i++) {
            // 1. 미세먼지 확산
            spread();

            // 2. 공기청정기 작동
            execute();
        }

        // 3. 총 미세먼지 양 계산 후 출력
        calcTotalAmount();
    }

    private static void check() {
        spreadable = new boolean[R][C];
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(map[i][j] > 0) spreadable[i][j] = true;
            }
        }
    }

    private static void clearMap() {
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                temp_arr[i][j] = 0;
            }
        }
    }

    private static void spread() {
        check();

        clearMap();

        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                if(!spreadable[r][c]) continue;

                int curr = map[r][c]; // 미세먼지의 양

                int cnt = 0; // 확산 가능한 방향 수
                int spreadAmount = calcSpreadAmount(curr); // 주변으로 확산되는 양
                for(int[] dir : dirs) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
                    if(map[nr][nc] == -1) continue;
                    temp_arr[nr][nc] += spreadAmount;
                    cnt++;
                }
                
                map[r][c] = calcRemainingAmount(curr, cnt); // r, c에 남는 미세먼지의 양
            }
        }

        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                map[i][j] += temp_arr[i][j];
            }
        }
    }

    private static int calcSpreadAmount(int A) {
        return A / 5;
    }

    private static int calcRemainingAmount(int A, int cnt) {
        return A - (A / 5) * cnt;
    }

    private static void execute() {
        int[][] temp_map = new int[R][C];

        // 1. 상단부
        int tmp1 = map[air_x1][C - 1]; // 우측 하단
        int tmp2 = map[0][C - 1]; // 우측 상단
        int tmp3 = map[0][0]; // 좌측 상단

        // 1-1. 왼쪽 -> 오른쪽
        for(int i = 2; i < C; i++) {
            temp_map[air_x1][i] = map[air_x1][i - 1];
        }
        temp_map[air_x1 - 1][C - 1] = tmp1;

        // 1-2. 아래쪽 -> 위쪽
        for(int i = 0; i < air_x1; i++) {
            temp_map[i][C - 1] = map[i + 1][C - 1];
        }
        temp_map[0][C - 2] = tmp2;

        // 1-3. 오른쪽 -> 왼쪽
        for(int i = 0; i < C - 1; i++) {
            temp_map[0][i] = map[0][i + 1];
        }
        temp_map[1][0] = tmp3;

        // 1-4. 위쪽 -> 아래쪽
        for(int i = 1; i < air_x1; i++) {
            temp_map[i][0] = map[i - 1][0];
        }

        // 2. 하단부
        tmp1 = map[air_x2][C - 1];
        tmp2 = map[R - 1][C - 1];
        tmp3 = map[R - 1][0];

        // 2-1. 왼쪽 -> 오른쪽
        for(int i = 2; i < C; i++) {
            temp_map[air_x2][i] = map[air_x2][i - 1];
        }
        temp_map[air_x2 + 1][C - 1] = tmp1;

        // 2-2. 위쪽 -> 아래쪽
        for(int i = air_x2 + 2; i < R; i++) {
            temp_map[i][C - 1] = map[i - 1][C - 1];
        }
        temp_map[R - 1][C - 2] = tmp2;

        // 2-3. 오른쪽 -> 왼쪽
        for(int i = 0; i < C - 2; i++) {
            temp_map[R - 1][i] = map[R - 1][i + 1];
        }
        temp_map[R - 2][0] = tmp3;

        // 2-4. 아래쪽 -> 위쪽
        for(int i = air_x2 + 1; i < R - 2; i++) {
            temp_map[i][0] = map[i + 1][0];
        }

        for(int i = 0; i < R; i++) {
            map[i][0] = temp_map[i][0];
            map[i][C - 1] = temp_map[i][C - 1];
        }
        for(int i = 0; i < C; i++) {
            map[0][i] = temp_map[0][i];
            map[R - 1][i] = temp_map[R - 1][i];
            map[air_x1][i] = temp_map[air_x1][i];
            map[air_x2][i] = temp_map[air_x2][i];
        }
        map[air_x1][0] = -1;
        map[air_x2][0] = -1;
    }

    private static void calcTotalAmount() {
        int totalAmount = 0;

        // System.out.println("===================================");
        for(int r = 0; r < R; r++) {
            for(int c = 0; c < C; c++) {
                // System.out.print(map[r][c] + " ");
                if(map[r][c] == -1) continue;
                totalAmount += map[r][c];
            }
            // System.out.println();
        }

        // System.out.println("===================================");
        System.out.println(totalAmount);
        
    }

}