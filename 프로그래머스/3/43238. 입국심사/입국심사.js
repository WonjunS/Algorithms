function solution(n, times) {
    let answer = 0;
    
    let start = 1;
    let end = 1_000_000_000_000_000_000;
    
    while(true) {
        const mid = Math.floor((start + end) / 2);
        
        if(start >= end) break;
        
        if(isAvailable(mid, n, times)) {
            answer = mid;
            end = mid;
        } else {
            start = mid + 1;
        }
    }
    
    return answer;
}

const isAvailable = (mid, n, times) => {
    let sum = 0;
    
    for(let time of times) {
        sum += Math.floor(mid / time);
    }
    
    if(sum >= n) return true;
    
    return false;
};