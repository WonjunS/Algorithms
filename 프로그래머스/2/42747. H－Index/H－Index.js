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
        return this.stack.splice(this.size() - 1);
    }
    
    isEmpty() {
        return this.stack.length === 0;
    }
        
    size() {
        return this.stack.length;
    }
}

function solution(citations) {
    const N = citations.length;
    
    citations.sort((o1, o2) => (o1 - o2));
    
    let stack = new Stack();
    for(let i = 0; i < N; i++) {
        stack.push(citations[i]);
    }
    
    let answer = 0;
    for(let h = N; h >= 0; h--) {
        while(!stack.isEmpty() && stack.peek() >= h) {
            stack.pop();
        }
        
        const over = N - stack.size();
        const under = stack.size();
        
        if(over >= h && under <= h) {
            answer = h;
            break;
        }
    }
    
    return answer;
}