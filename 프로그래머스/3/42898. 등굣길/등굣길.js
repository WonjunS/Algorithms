function solution(m, n, puddles) {
    let D = [];
    
    const mod = 1_000_000_007;
    
    for(let i = 0; i < n; i++) {
        D[i] = [];
        for(let j = 0; j < m; j++) {
            D[i][j] = 0;
        }
    }
    
    D[0][0] = 1;
    
    for(let i = 0; i < n; i++) {
        for(let j = 0; j < m; j++) {
            if(i === 0 && j === 0) continue;
            if(isPuddle(puddles, i, j)) {
                D[i][j] = 0;
            } else {
                if(i === 0) {
                    D[i][j] = D[i][j - 1];
                    continue;
                }
                if(j === 0) {
                    D[i][j] = D[i - 1][j];
                    continue;
                }
                D[i][j] = (D[i - 1][j] + D[i][j - 1]) % mod;
            }
        }
    }
    
    return D[n - 1][m - 1];
}

const isPuddle = (puddles, i, j) => {
    for(let t = 0; t < puddles.length; t++) {
        const x = puddles[t][0] - 1;
        const y = puddles[t][1] - 1;
        
        if(i === y && j === x) {
            return true;
        }
    }
    
    return false;
}