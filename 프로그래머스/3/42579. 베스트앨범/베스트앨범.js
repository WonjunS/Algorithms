function solution(genres, plays) {
    let map = new Map();
    let scoreMap = new Map();
    for(let i = 0; i < genres.length; i++) {
        const genre = genres[i];
        const play = plays[i];
        
        if(!map.has(genre)) {
            map.set(genre, []);
            scoreMap.set(genre, 0);
        }
        
        const data = {
            idx: i,
            genre: genre,
            play: play,
        }
        map.set(genre, [...map.get(genre), data]);
        
        scoreMap.set(genre, scoreMap.get(genre) + play);
    }
    
    for(let key of map.keys()) {
        map.get(key).sort((a, b) => {
            if(a.play === b.play) {
                return a.idx - b.idx;
            }
            return b.play - a.play;
        });
    }
    
    const sortedMap = new Map([...scoreMap.entries()].sort((a, b) => b[1] - a[1]));
    console.log(sortedMap);
                                                              
    let usedGenre = [];
    let answer = [];
    for(let genre of sortedMap.keys()) {
        if(usedGenre.includes(genre)) continue;
        if(map.get(genre).length >= 2) {
            answer.push(map.get(genre)[0].idx);
            answer.push(map.get(genre)[1].idx);
        } else {
            answer.push(map.get(genre)[0].idx);
        }
        usedGenre.push(genre);
    }
    
    return answer;
}