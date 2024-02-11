function solution(brown, yellow) {
    let answer = [];
    
    const sum = brown + yellow;
    for(let x = sum; x >= Math.sqrt(sum); x--) {
        const y = sum / x;
        
        if(!isInteger(y, sum)) continue;
        
        if((x - 2) * (y - 2) === yellow) {
            answer.push(x);
            answer.push(y);
            break;
        }
    }
    
    return answer;
}

const isInteger = (x, n) => {
    return n % x === 0;
};