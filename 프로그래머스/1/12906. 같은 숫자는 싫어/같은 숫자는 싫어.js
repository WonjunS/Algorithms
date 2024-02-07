class Queue {
    constructor() {
        this.queue = [];
    }
    
    enqueue(n) {
        this.queue.push(n);
    }
    
    dequeue() {
        if(this.queue.length > 0) {
            return this.queue.shift();
        }
        return -1;
    }
    
    isEmpty() {
        return this.queue.length === 0;
    }
    
    size() {
        return this.queue.length;
    }
}

class Stack {
    constructor() {
        this.stack = [];
    }
    
    push(n) {
        this.stack.push(n);
    }
    
    peek() {
        return this.stack[this.size() - 1];
    }
    
    pop() {
        if(this.stack.length > 0) {
            const value = this.stack[this.size() - 1];
            this.stack.splice(this.size() - 1);
            return value;
        }
        return -1;
    }
    
    size() {
        return this.stack.length;
    }
}

function solution(arr) {
    let answer = [];
    
    const q = new Queue();
    
//     let prev = -1;
//     for(let i = 0; i < arr.length; i++) {
//         if(prev !== arr[i]) {
//             q.enqueue(arr[i]);
//         }
//         prev = arr[i];
//     }
    
//     while(!q.isEmpty()) {
//         answer.push(q.dequeue());
//     }
    
    const stk = new Stack();

    let prev = -1;
    for(let i = arr.length - 1; i >= 0; i--) {
        if(prev !== arr[i]) {
            stk.push(arr[i]);
        }
        prev = arr[i];
    }
    
    while(stk.size() > 0) {
        answer.push(stk.pop());
    }
    
    return answer;
}