const KEY_MAP = {
    '0': [' '], '1': [' '],
    '2': ['a', 'b', 'c'], '3': ['d', 'e', 'f'],
    '4': ['g', 'h', 'i'], '5': ['j', 'k', 'l'],
    '6': ['m', 'n', 'o'], '7': ['p', 'q', 'r', 's'],
    '8': ['t', 'u', 'v'], '9': ['w', 'x', 'y', 'z']
};

const wordMap = {};

async function loadWords() {
    try {
        const resp = await fetch('SentimentValues.txt');
        if (!resp.ok) throw new Error('File not found');
        const text = await resp.text();
        for (const line of text.split('\n')) {
            const comma = line.lastIndexOf(',');
            if (comma < 0) continue;
            const word = line.substring(0, comma).trim().toLowerCase();
            const val = parseFloat(line.substring(comma + 1));
            if (word.length >= 2 && word.length <= 10 && /^[a-z]+$/.test(word) && !isNaN(val)) {
                wordMap[word] = true;
            }
        }
        postMessage({ type: 'loaded', count: Object.keys(wordMap).length });
    } catch (e) {
        postMessage({ type: 'error', error: e.message });
    }
}

loadWords();

function containsWord(combo) {
    for (const w in wordMap) { if (combo.includes(w)) return true; }
    return false;
}

function buriedWord(combo) {
    let longest = '';
    for (const w in wordMap) {
        if (combo.includes(w) && w.length > longest.length) longest = w;
    }
    return longest;
}

function getOptions(digits) {
    let options = [''];
    for (const d of digits) {
        const letters = KEY_MAP[d] || [' '];
        const next = [];
        for (const opt of options) for (const ch of letters) next.push(opt + ch);
        options = next;
        if (options.length > 500000) break;
    }
    return options;
}

function buildResults(digits, rawOptions) {
    const filtered = rawOptions.filter(o => containsWord(o));
    const results = [], seen = new Set();
    for (const opt of filtered) {
        const word = buriedWord(opt);
        const start = opt.indexOf(word), end = start + word.length;
        let display = '';
        for (let i = 0; i < opt.length; i++) display += (i >= start && i < end) ? opt[i] : digits[i];
        if (!seen.has(display)) { seen.add(display); results.push({ display, word }); }
    }
    return results;
}

onmessage = function(e) {
    if (e.data.type === 'calculate') {
        const digits = e.data.digits;
        const options = getOptions(digits);
        const results = buildResults(digits, options);
        
        postMessage({
            type: 'results',
            results: results,
            optionsLength: options.length
        });
    }
};
