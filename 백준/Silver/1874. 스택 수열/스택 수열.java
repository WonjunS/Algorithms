import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> stk = new Stack<>();

        N = sc.nextInt();
        for(int i = 1; i <= N; i++) {
            list.add(sc.nextInt());
        }

        int idx = 0;
        int n = 1;
        while(n <= N + 1 && idx < N) {
            int curr = list.get(idx);
            boolean flag = true;
            if(!stk.isEmpty() && curr == stk.peek()) {
                stk.pop();
                sb.append('-').append('\n');
                idx++;
                flag = false;
                continue;
            }
            while(n <= N) {
                flag = false;
                stk.push(n);
                sb.append('+').append('\n');
                if(n == curr) {
                    n++;
                    break;
                }
                n++;
            }
            if(flag) break;
        }

        if(stk.size() == 0) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}