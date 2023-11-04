function solution(babbling) {
    let answer = 0;
    
    const list = ["aya", "ye", "woo", "ma"];
    
    for(let b of babbling) {
        const used = [false, false, false, false];
        
        while(true) {
            let isAvailable = false;
            
            if(b.length === 0) {
                answer++;
                break;
            }

            if(b.length < 2) {
                break;
            }

            const twoWords = b.substring(0, 2);
            if(twoWords === list[1] && !used[1]) {
                used[1] = true;
                b = b.substring(2, b.length);
                isAvailable = true;
                continue;
            }
            if(twoWords === list[3] && !used[3]) {
                used[3] = true;
                b = b.substring(2, b.length);
                isAvailable = true;
                continue;
            }
            
            if(b.length >= 3) {
                const threeWords = b.substring(0, 3);
                if(threeWords === list[0] && !used[0]) {
                    used[0] = true;
                    b = b.substring(3, b.length);
                    isAvailable = true;
                    continue;
                }
                if(threeWords === list[2] && !used[2]) {
                    used[2] = true;
                    b = b.substring(3, b.length);
                    isAvailable = true;
                continue;
                }
            }
            
            if(!isAvailable) {
                break;
            }
        }
        
        
    }
    
    return answer;
}