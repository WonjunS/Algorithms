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
        const value = this.stack[this.size() - 1];
        this.stack.splice(this.size() - 1);
        return value;
    }
    
    size() {
        return this.stack.length;
    }
    
    isEmpty() {
        return this.stack.length === 0;
    }
}

function solution(s){
    const stack = new Stack();
    
    for(let i = 0; i < s.length; i++) {
        const c = s.substring(i, i + 1);
        
        if(stack.isEmpty()) {
            stack.push(c);
            continue;
        }
        
        if(c === ')' && stack.peek() === '(') {
            stack.pop();
            continue;
        }
        
        if(c === '(' && stack.peek() === '(') {
            stack.push(c);
            continue;
        }
        
        break;
    }

    return stack.isEmpty();
}