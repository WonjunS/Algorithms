import java.util.*;

public class Main {

    static class Item {
        private int weight;
        private int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    static int N, K;
    static int[][] Dy;
    static Item[] items;

    static void input() {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();
        Dy = new int[N + 1][K + 1];
        items = new Item[N + 1];
        for(int i = 1; i <= N; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();

            items[i] = new Item(w, v);
        }
    }

    static void pro() {        
        for(int i = 1; i <= N; i++) {
            int w = items[i].weight;
            int v = items[i].value;
            for(int j = 1; j <= K; j++) {
                if(j >= w) {
                    Dy[i][j] = Math.max(Dy[i - 1][j], Dy[i - 1][j - w] + v);
                } else {
                    Dy[i][j] = Dy[i - 1][j];
                }
            }
        }
        
        System.out.println(Dy[N][K]);
    }

    public static void main(String[] args) {
        input();
        pro();
    }
}