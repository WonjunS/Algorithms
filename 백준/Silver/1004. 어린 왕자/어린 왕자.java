import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                int sum1 = (int) Math.pow((x1 - cx), 2) + (int) Math.pow((y1 - cy), 2);
                int sum2 = (int) Math.pow((x2 - cx), 2) + (int) Math.pow((y2 - cy), 2);

                if(sum1 < r * r && sum2 < r * r) continue;
                if(sum1 < r * r) cnt++;
                if(sum2 < r * r) cnt++;
            }

            sb.append(cnt).append('\n');
        }

        br.close();

        System.out.println(sb.toString());
    }

}