function solution(k, dungeons) {
    N = dungeons.length;
    for(let i = 0; i < N; i++) {
        visited[i] = false;
    }
    
    dfs('', dungeons, k, 0);
    
    return answer;
}

let N = 0;
let answer = 0;
let visited = [];

const dfs = (str, dungeons, curr, cnt) => {
    answer = Math.max(answer, cnt);
    
    for(let i = 0; i < N; i++) {
        if(visited[i]) continue;
        if(dungeons[i][0] > curr) continue;
        if(curr - dungeons[i][1] < 0) continue;
        
        visited[i] = true;
        
        dfs(str + '' + i, dungeons, curr - dungeons[i][1], cnt + 1);
        
        visited[i] = false;
    }
}