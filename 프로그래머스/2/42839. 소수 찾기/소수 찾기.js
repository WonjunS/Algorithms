function solution(numbers) {
    let numberList = [];
    
    const N = numbers.length;
    
    for(let i = 0; i < N; i++) {
        visited[i] = false;
    }
    
    dfs('', numbers);
    
    return answer;
}

let answer = 0;
let numberList = [];
let visited = [];

const dfs = (str, numbers) => {
    
    if(str.length !== 0 && isPrimeNumber(parseInt(str)) && !numberList.includes(parseInt(str))) {
        numberList.push(parseInt(str));
        answer++;
    }
    
    if(str.length === numbers.length) {
        return ;
    }
    
    for(let i = 0; i < numbers.length; i++) {
        if(visited[i]) continue;
        
        visited[i] = true;
        dfs(str + numbers.charAt(i), numbers);
        visited[i] = false;
    }
};

const isPrimeNumber = (n) => {
    if(n === 1) return false;
    if(n === 2) return true;
    if(n % 2 === 0) return false;
    for(let i = 3; i <= Math.sqrt(n); i += 2) {
        if(n % i === 0) {
            return false;
        }
    }
    
    return true;
};
