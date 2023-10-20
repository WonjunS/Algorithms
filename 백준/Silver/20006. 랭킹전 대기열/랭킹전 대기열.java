import java.util.*;
import java.io.*;

public class Main {
    
    private static class Player {
        private int level;
        private String nickname;
        
        public Player(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        List<Player>[] rooms = new ArrayList[p];
        for(int i = 0; i < p; i++) {
            rooms[i] = new ArrayList<>();
        }
        
        int count = 0;
        while(p-- > 0) {
            st = new StringTokenizer(br.readLine());
            
            int l = Integer.parseInt(st.nextToken());
            String n = st.nextToken();
            
            boolean arranged = false;

            for(int i = 0; i < count; i++) {
                if(rooms[i].size() == m) { // 정원이 다 찼으면 다음 방으로 넘김
                    continue;
                }

                Player player = rooms[i].get(0); // 첫번째 입장한 플레이어
                if(Math.abs(player.level - l) <= 10) { // 레벨 차이
                    rooms[i].add(new Player(l, n)); // 해당 방에 플레이어 추가
                    arranged = true;
                    break;
                } else {
                    continue;
                }
            }
            
            if(!arranged) { // 플레이어가 입장 못했으면 새로운 방 생성
                rooms[count].add(new Player(l, n));
                count++;
            }
        }

        for(int i = 0; i < count; i++) {
            List<Player> room = rooms[i];

            if(room.size() == m) {
                sb.append("Started!").append('\n');
            } else {
                sb.append("Waiting!").append('\n');
            }

            room.sort((o1, o2) -> o1.nickname.compareTo(o2.nickname));
            for(Player player : room) {
                sb.append(player.level).append(' ');
                sb.append(player.nickname).append('\n');
            }
        }

        System.out.println(sb.toString());
    }
    
}