import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int x3 = Integer.parseInt(st.nextToken());
        int y3 = Integer.parseInt(st.nextToken());

        int answer;

        int sum = (x1 * y2 + x2 * y3 + x3 * y1) - (x1 * y3 + x2 * y1 + x3 * y2);
        if(sum > 0) {
            answer = 1;
        } else if(sum == 0) {
            answer = 0;
        } else {
            answer = -1;
        }

        System.out.println(answer);
    }
}