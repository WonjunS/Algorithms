function solution(word) {
    init('');
    
    list.sort();
    
    for(let i = 1; i <= list.length; i++) {
        if(list[i - 1] === word) {
            return i;
        }
    }
    
    return -1;
}

const vowel = ['A', 'E', 'I', 'O', 'U'];
let list = [];

const init = (str, idx) => {
    if(str.length > 5) return;
    
    if(str.length > 0 && !list.includes(str)) {
        list.push(str);
    }
    
    for(let i = 0; i < 5; i++) {
        init(str + vowel[i]);
    }
}