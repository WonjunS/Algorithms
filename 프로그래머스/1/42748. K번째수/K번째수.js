function solution(array, commands) {
    let answer = [];

    for(let command of commands) {
        const [i, j, k] = command;
        
        let subArr = [];
        
        for(let n = i; n <= j; n++) {
            subArr.push(array[n - 1]);
        }
        
        subArr.sort((o1, o2) => (o1 - o2));
        
        answer.push(subArr[k - 1]);
    }
    
    return answer;
}