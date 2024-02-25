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

function solution(n, edge) {
    for(let i = 0; i <= n; i++) {
        adj[i] = [];
        dist[i] = 20000;
    }
    
    for(let vertex of edge) {
        const [a, b] = vertex;
        
        adj[a].push(b);
        adj[b].push(a);
    }
    
    for(let i = 1; i <= n; i++) {
        adj[i].sort();
    }
    
    bfs();
    
    let cnt = 0;
    let max = 0;
    for(let i = 2; i <= n; i++) {
        if(max < dist[i]) {
            cnt = 1;
            max = dist[i];
            continue;
        }
        if(max === dist[i]) {
            cnt++;
            continue;
        }
    }
    
    return cnt;
}

let adj = [];
let dist = [];

const bfs = () => {
    const q = new Queue();
    q.enqueue(1);
    dist[1] = 0;
    
    while(!q.isEmpty()) {
        const x = q.dequeue();
        
        for(let y of adj[x]) {
            if(dist[y] <= dist[x] + 1) continue;
            if(y === 1) continue;
            
            dist[y] = dist[x] + 1;
            q.enqueue(y);
        }
    }
}