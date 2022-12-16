import java.util.*;

public class Main {

    static int N, ans;
    static ArrayList<Integer> nums;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        nums = new ArrayList<>();
    }

    static void preprocess() {
        nums = new ArrayList<>();
        nums.add(0);
        for(int i = 1; i <= N; i++) {
            if(i == 1) continue;
            if(i == 2) nums.add(i);
            if(i % 2 == 0) continue;
            else {
                boolean isPrime = true;
                for(int j = 3; j <= Math.sqrt(i); j += 2) {
                    if(i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime) nums.add(i);
            }
        }
    }

    static void pro() {
        preprocess();

        int sum = 0;
        for(int L = 1, R = 0; L < nums.size(); L++) {
            while(sum < N && R < nums.size()) {
                sum += nums.get(R);
                R++;
            }
            if(sum == N) ans++;
            sum -= nums.get(L);
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}