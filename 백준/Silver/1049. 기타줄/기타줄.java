import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<Integer> package_six = new ArrayList<>();
        List<Integer> package_one = new ArrayList<>();

        while(M-- > 0) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            package_six.add(a);
            package_one.add(b);
        }

        package_six.sort((o1, o2) -> (o1 - o2));
        package_one.sort((o1, o2) -> (o1 - o2));

        int answer = 0;
        while(true) {
            if(N >= 6) {
                int x = package_six.get(0);
                int y = package_one.get(0) * 6;

                answer = answer + Math.min(x, y);
                N -= 6;
            } else {
                int x = package_six.get(0);
                int y = package_one.get(0) * N;

                answer = answer + Math.min(x, y);
                N = 0;
                break;
            }
        }

        System.out.println(answer);
    }

}