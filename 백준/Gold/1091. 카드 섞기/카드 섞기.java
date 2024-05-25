import java.util.*;
import java.io.*;

public class Main {

    private static int[] P, S, cards, initialCards;
    private static int N, answer;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        P = new int[N];
        S = new int[N];
        cards = new int[N];
        initialCards = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++) {
            cards[i] = i;
        }
        initialCards = cards.clone();

        shuffle();

        System.out.println(answer);
    }

    private static void shuffle() {
        if(answer > 0 && Arrays.equals(cards, initialCards)) {
            answer = -1;
            return;
        }

        if(checkOrder(cards)) {
            return;
        }

        answer++;

        int[] temp = new int[N];
        for(int i = 0; i < N; i++) {
            temp[S[i]] = cards[i];
        }

        cards = temp.clone();

        shuffle();
    }

    private static boolean checkOrder(int[] arr) {
        boolean flag = true;
        for(int i = 0; i < arr.length; i++) {
            if(P[cards[i]] != i % 3) {
                flag = false;
                break;
            }
        }

        return flag;
    }

}