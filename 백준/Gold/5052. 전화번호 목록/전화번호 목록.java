import java.util.*;

public class Main {

    static int T, N;
    static String[] str;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        T = sc.nextInt();
        for(int i = 0; i < T; i++) {
            N = sc.nextInt();
            str = new String[N];
            for(int j = 0; j < N; j++) {
                str[j] = sc.next();
            }
            Arrays.sort(str);

            boolean flag = false;
            for(int j = 0; j < N - 1; j++) {
                String s1 = str[j];
                String s2 = str[j + 1];
                if(s2.startsWith(s1)) {
                    flag = true;
                }
            }
            if(!flag) {
                sb.append("YES").append('\n');
            } else {
                sb.append("NO").append('\n');
            }
        }
        System.out.println(sb);
    }
}