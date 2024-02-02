function solution(nums) {
    const N = nums.length / 2;
    
    let set = new Set();
    for(let x of nums) {
        set.add(x);
    }
    
    return set.size > N ? N : set.size;
}