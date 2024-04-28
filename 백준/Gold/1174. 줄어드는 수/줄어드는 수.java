import java.util.*;

public class Main {

    private static List<Long> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        init();

        int N = sc.nextInt();

        long answer = (list.size() >= N) ? list.get(N - 1) : -1;

        System.out.println(answer);
    }

    private static void init() {
        list = new ArrayList<>();

        for(int i = 0; i <= 9; i++) {
            dfs(i, i + "");
        }

        list.sort((o1, o2) -> (o1.compareTo(o2)));
    }

    private static void dfs(int n, String num) {
        if(!list.contains(Long.parseLong(num))) list.add(Long.parseLong(num));

        for(int i = n - 1; i >= 0; i--) {
            dfs(i, num + "" + i);
        }
    }

}