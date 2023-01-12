import java.util.*;

public class Main {

    static int[] money = {500, 100, 50, 10, 5, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int idx = 0, count = 0;
        int R = 1000 - N;
        while(R > 0 && idx < 6) {
            int curr = money[idx];
            int d = R / curr;

            count += d;
            R -= (d * curr);

            idx++;
        }

        System.out.println(count);
    }
}