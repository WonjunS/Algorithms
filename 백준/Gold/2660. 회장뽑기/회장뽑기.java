import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static boolean[] checked, isFriend;
    private static List<Integer>[] friends;
    private static List<Score> scores;

    private static class Score {
        private int idx;
        private int score;

        public Score(int idx, int score) {
            this.idx = idx;
            this.score = score;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        friends = new ArrayList[N + 1];

        for(int i = 0; i <= N; i++) {
            friends[i] = new ArrayList<>();
        }

        while(true) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1) break;

            friends[a].add(b);
            friends[b].add(a);
        }

        // 점수가 체크된 회원 여부
        checked = new boolean[N + 1];

        // 친구인지 확인
        isFriend = new boolean[N + 1];

        // 각 회원의 점수 저장
        scores = new ArrayList<>();
        
        // n점을 기록한 회원 수
        int cnt = 0;

        // n점인 회원이 있는지 확인
        for(int i = 1; i <= 50; i++) {
            if(cnt > 0) break;
            for(int j = 1; j <= N; j++) {
                if(checked[j]) continue;

                dfs(j, 0, i);

                if(isAllFriend(j)) {
                    checked[j] = true;
                    cnt++;
                    scores.add(new Score(j, i));
                }

                resetArray();
            }
        }

        scores.sort((o1, o2) -> (o1.idx - o2.idx));

        // 가장 낮은 점수
        int min = scores.get(0).score;

        sb.append(min).append(' ').append(cnt).append('\n');

        for(Score s : scores) {
            sb.append(s.idx).append(' ');
        }

        System.out.println(sb.toString());
        
    }

    // 친구 관계를 만족하는지 확인
    private static boolean isAllFriend(int idx) {
        for(int i = 1; i <= N; i++) {
            if(i == idx) continue;
            if(!isFriend[i]) return false;
        }

        return true;
    }

    // 배열 초기화
    private static void resetArray() {
        for(int i = 1; i <= N; i++) {
            isFriend[i] = false;
        }
    }

    // 친구, 친구 ~ 친구, ... 관계 확인
    private static void dfs(int idx, int currDepth, int depth) {
        isFriend[idx] = true;

        if(currDepth == depth) {
            return;
        }

        for(int y : friends[idx]) {
            dfs(y, currDepth + 1, depth);
        }
    }

}