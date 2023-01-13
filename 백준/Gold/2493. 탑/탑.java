import java.util.*;
import java.io.*;

public class Main {

    static class Info {
        private int height;
        private int idx;

        public Info(int height, int idx) {
            this.height = height;
            this.idx = idx;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];
        Stack<Info> stk = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            while(!stk.isEmpty() && stk.peek().height < arr[i]) {
                stk.pop();
            }
            if(stk.isEmpty()) {
                sb.append('0').append(' ');
            } else {
                sb.append(stk.peek().idx).append(' ');
            }
            stk.push(new Info(arr[i], i));
        }

        System.out.println(sb);
    }
}