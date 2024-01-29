function solution(triangle) {
    let answer = 0;
    const N = triangle.length;
    
    let arr = new Array();
    for(let i = 0; i < N; i++) {
        arr[i] = [];
        for(let j = 0; j < N; j++) {
            arr[i][j] = 0;
        }
    }
    
    arr[0][0] = triangle[0][0];
    
    for(let i = 1; i < N; i++) {
        for(let j = 0; j < triangle[i].length; j++) {
            if(j === 0) {
                arr[i][j] = arr[i - 1][j] + triangle[i][j];
            } else if(j === triangle[i].length - 1) {
                arr[i][j] = arr[i - 1][j - 1] + triangle[i][j]; 
            } else {
                arr[i][j] = Math.max(arr[i - 1][j - 1], arr[i - 1][j]) + triangle[i][j];
            }
        }
    }
    
    for(let i = 0; i < N; i++) {
        answer = Math.max(arr[N - 1][i], answer);
    }
    
    return answer;
}