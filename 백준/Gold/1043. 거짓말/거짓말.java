import java.util.*;
import java.io.*;

public class Main {

    private static int N, M, k;
    private static List<Integer> knowingList; // 진실을 아는 사람 목록
    private static Map<Integer, List<Integer>> partyMap; // [파티 번호] - [참석자 번호 목록] 구조
    private static List<Integer>[] participantArray; // [참석자 번호] - [참가하는 파티 번호] 구조
    private static boolean[] notAvailable; // 해당 파티에서 거짓말을 할 수 있는지 여부
    private static boolean[][] checked; // 해당 번호의 참석자를 체크한 이력이 있는지 확인

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());

        knowingList = new ArrayList<>();
        if(k > 0) {
            for(int i = 0; i < k; i++) {
                int x = Integer.parseInt(st.nextToken());
                knowingList.add(x);
            }
        }

        notAvailable = new boolean[M + 1];
        
        partyMap = new HashMap<>();
        participantArray = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            participantArray[i] = new ArrayList<>();
        }

        for(int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            List<Integer> participants = new ArrayList<>();
            for(int j = 0; j < p; j++) {
                int x = Integer.parseInt(st.nextToken());
                participants.add(x);
                participantArray[x].add(i);
            }

            partyMap.put(i, participants);
        }

        checked = new boolean[N + 1][M + 1];

        for(int no : knowingList) {
            search(no);
        }

        int answer = 0;
        for(int i = 1; i <= M; i++) {
            if(notAvailable[i] == false) {
                answer++;
            }
        }

        System.out.println(answer);
    }

    private static void search(int no) {
        for(int partyNo : participantArray[no]) {
            checked[no][partyNo] = true;

            notAvailable[partyNo] = true;

            for(int partNo : partyMap.get(partyNo)) {
                if(checked[partNo][partyNo]) continue;
                search(partNo);
            }
        }
    }

}