function solution(answers) {
    let answer = new Array();
    
    const pattern1 = [1, 2, 3, 4, 5];
    const pattern2 = [2, 1, 2, 3, 2, 4, 2, 5];
    const pattern3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5];
    
    let stu1 = 0;
    let stu2 = 0;
    let stu3 = 0;
    for(let i = 0; i < answers.length; i++) {
        const x = answers[i];
        
        if(pattern1[i % 5] == x) stu1++;
        if(pattern2[i % 8] == x) stu2++;
        if(pattern3[i % 10] == x) stu3++;
    }
    
    const max = Math.max(stu1, Math.max(stu2, stu3));
    if(max === stu1) answer.push(1);
    if(max === stu2) answer.push(2);
    if(max === stu3) answer.push(3);
    
    return answer;
}