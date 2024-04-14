function solution(distance, rocks, n) {
    let left = 1, right = distance + 1;
    
    rocks.sort((a, b) => (a - b));
    
    let D = new Array();
    D[0] = rocks[0];
    for(let i = 1; i < rocks.length; i++) {
        D[i] = rocks[i] - rocks[i - 1];
    }
    D[rocks.length] = distance - rocks[rocks.length - 1];
    
    while(left < right) {
        let mid = parseInt((left + right) / 2);
        
        let sum = 0;
        let cnt = 0;
        
        for(let i = 0; i < D.length; i++) {
            sum += D[i];
            if(sum < mid) {
                cnt++;
            } else {
                sum = 0;
            }
        }
        
        if(cnt <= n) {
            left = mid + 1;
        } else {
            right = mid;
        }
    }
    
    return left - 1;
}