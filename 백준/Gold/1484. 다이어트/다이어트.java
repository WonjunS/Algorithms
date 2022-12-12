import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static int G;
    static ArrayList<Integer> answer;

    static void input() {
        Scanner sc = new Scanner(System.in);

        G = sc.nextInt();
    }

    static void pro() {
        answer = new ArrayList<>();

        search();

        if(answer.size() == 0) {
            System.out.println("-1");
            return;
        }
        Collections.sort(answer);
        for(int n : answer) {
            sb.append(n).append('\n');
        }
        System.out.println(sb);
    }

    static void search() {
        for(int L = 1, R = 1; R <= 50001; L++) {
            while((R * R) - (L * L) < G) {
                R++;
            }
            if((R * R - L * L) == G) answer.add(R);
        }
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}