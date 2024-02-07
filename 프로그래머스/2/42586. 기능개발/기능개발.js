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

function solution(progresses, speeds) {
    const stk = new Stack();
    
    for(let i = progresses.length - 1; i >= 0; i--) {
        const prog = progresses[i];
        const speed = speeds[i];
        
        const day = Math.ceil((100 - prog) / speed);
        
        stk.push(day);
    }
    
    let answer = [];
    let cnt = 0;
    let prev = -1;
    while(!stk.isEmpty()) {
        if(prev === -1) {
            prev = stk.pop();
            cnt++;
        }
        
        while(!stk.isEmpty() && prev >= stk.peek()) {
            stk.pop();
            cnt++;
        }
        
        answer.push(cnt);
        prev = -1;
        cnt = 0;
    }
    
    return answer;
}