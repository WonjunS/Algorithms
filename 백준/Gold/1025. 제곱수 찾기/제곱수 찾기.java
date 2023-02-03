import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
    static int max = -1;
    static int[][] map;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for(int i = 0; i < N; i++) {
            String str = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                for(int mi = -N; mi < N; mi++) {
                    for(int mj = -M; mj < M; mj++) {

                        if(mi == 0 && mj == 0) continue;

                        int num = 0;
                        int newI = i;
                        int newJ = j;
                        while(newI >= 0 && newJ >= 0 && newI < N && newJ < M) {
                            num = (num * 10) + map[newI][newJ];

                            if(isSquareNumber(num)) max = Math.max(max, num);

                            newI += mi;
                            newJ += mj;
                        }
                    }
                }
            }
        }
        
        System.out.println(max);
    }

    static boolean isSquareNumber(int num) {
        int x = (int) Math.sqrt(num);

        if(x * x == num) return true;
        return false;
    }

    static int reverseNum(int num) {
        int rev_num = 0;

        String val = Integer.toString(num);
        for(int i = val.length() - 1; i >= 0; i--) {
            rev_num = (rev_num * 10) + Character.getNumericValue(val.charAt(i));
        }

        return rev_num;
    }
}