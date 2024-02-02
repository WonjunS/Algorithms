function solution(phone_book) {
    let answer = true;
    
    phone_book.sort();
    
    let tmp = '';
    for(let i = 0; i < phone_book.length; i++) {
        const phone = phone_book[i];
        
        const len = Math.min(tmp.length, phone.length);
        
        const prev = tmp.substring(0, len);
        const curr = phone.substring(0, len);
        
        if(tmp !== '' && prev === curr) {
            answer = false;
            break;
        }
        
        tmp = phone_book[i];
    }
    
    return answer;
}