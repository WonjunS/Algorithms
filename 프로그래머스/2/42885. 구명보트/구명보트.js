function solution(people, limit) {
    let answer = 0;
    
    people.sort((o1, o2) => (o1 - o2));
    
    let left = 0;
    let right = people.length - 1;
    while(left < right) {
        if(people[left] + people[right] > limit) {
            right--;
        } else {
            left++;
            right--;
        }
        answer++;
    }
    
    if(left === right) answer++;
    
    return answer;
}