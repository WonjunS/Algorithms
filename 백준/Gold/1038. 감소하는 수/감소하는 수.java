import java.util.*;

public class Main {

    static int N;
    static ArrayList<Long> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        list = new ArrayList<>();

        for(int i = 0; i <= 9; i++) {
            find(i, 1);
        }

        Collections.sort(list);

        if(N >= list.size()) {
            System.out.println("-1");
        } else {
            System.out.println(list.get(N));
        }
    }

    static void find(long num, int idx) {
        if(idx > 10) return;

        list.add(num);
        for(int i = 0; i < (num % 10); i++) {
            find((num * 10) + i, idx + 1);
        }
    }
}