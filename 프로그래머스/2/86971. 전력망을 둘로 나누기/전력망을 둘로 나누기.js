function solution(n, wires) {
    let answer = 100;
    
    for(let i = 0; i <= n; i++) {
        map.set(i, []);
        visited.push(false);
    }
    
    for(let i = 0; i < wires.length; i++) {
        const x = wires[i][0];
        const y = wires[i][1];
        
        let arr1 = map.get(x);
        arr1.push(y);
        map.set(x, arr1);
        
        let arr2 = map.get(y);
        arr2.push(x);
        map.set(y, arr2);
    }
    
    
    for(let i = 0; i < wires.length; i++) {
        const x = wires[i][0];
        const y = wires[i][1];
        
        resetFilter(n);
        
        dfs(x, y);
        const n1 = cnt;
        
        resetFilter(n);
        
        dfs(y, x);
        const n2 = cnt;
        
        answer = Math.min(answer, Math.abs(n1 - n2));
    }
    
    return answer;
}

let map = new Map();
let visited = [];
let cnt = 0;

const resetFilter = (n) => {
    cnt = 0;
    for(let i = 0; i <= n; i++) {
        visited[i] = false;
    }
}

const dfs = (a, b) => {
    visited[a] = true;
    cnt++;
    
    for(let n of map.get(a)) {
        if(n === b) continue;
        if(visited[n]) continue;
        
        dfs(n, b);
    }
}