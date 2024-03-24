class Queue {
    constructor() {
        this.queue = [];
    }
    
    enqueue(n) {
        this.queue.push(n);
    }
    
    dequeue() {
        return this.queue.shift();
    }
    
    isEmpty() {
        return this.queue.length === 0;
    }
}

let n, m;
let visited = [];
let total = [];
const dirs = [[1, 0], [0, 1], [-1, 0], [0, -1]];

function solution(land) {
    let answer = 0;
    
    n = land.length;
    m = land[0].length;
    
    for(let i = 0; i < n; i++) {
        visited.push([]);
        for(let j = 0; j < m; j++) {
            visited[i].push(false);
        }
    }
    
    for(let i = 0; i < m; i++) {
        total[i] = 0;
    }
    
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            if(visited[i][j]) continue;
            if(land[i][j] === 0) continue;
            
            bfs(i, j, land);
        }
    }
    
    for(let amount of total) {
        answer = Math.max(amount, answer);
    }
    
    return answer;
}

const bfs = (a, b, land) => {
    const q = new Queue();
    let visitHole = [];
    visited[a][b] = true;
    q.enqueue([a, b]);
    visitHole.push(b);
    
    let amount = 0;
    
    while(!q.isEmpty()) {
        const [x, y] = q.dequeue();
        amount++;
        
        for(let dir of dirs) {
            const [a, b] = dir;
            
            const nx = x + a;
            const ny = y + b;
            
            if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
            if(land[nx][ny] === 0) continue;
            if(visited[nx][ny]) continue;
            
            visited[nx][ny] = true;
            if(!visitHole.includes(ny)) visitHole.push(ny);
            q.enqueue([nx, ny]);
            
        }
    }
    
    for(let idx of visitHole) {
        total[idx] += amount;
    }
}