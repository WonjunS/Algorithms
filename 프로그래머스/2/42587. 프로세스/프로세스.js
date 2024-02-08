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

function solution(priorities, location) {
    let answer = 0;
    
    const queue = new Queue();
    for(let i = 0; i < priorities.length; i++) {
        queue.enqueue({
            idx: i,
            priority: priorities[i],
        });
    }
    
    let cnt = 0;
    
    while(!queue.isEmpty()) {
        const process = queue.dequeue();
        
        let flag = false;
        
        for(let wait of queue.queue) {
            if(process.priority < wait.priority) {
                flag = true;
                break;
            }
        }
        
        if(flag) {
            queue.enqueue(process);
            continue;
        }
        
        cnt++;
        
        if(process.idx === location) {
            answer = cnt;
            break;
        }
    }
    
    return answer;
}