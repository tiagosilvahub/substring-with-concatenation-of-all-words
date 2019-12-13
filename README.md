# substring-with-concatenation-of-all-words
You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

https://leetcode.com/problems/substring-with-concatenation-of-all-words/

Example 1:
```
Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
```

Explanation: Substrings starting at index 0 and 9 are "barfoo" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.

Example 2:
```
Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []
```

Sliding window technique, using a HashMap to keep track of the current state of the inside of the window, at every step of the window (right or left edge) update the state. 

O(n * k) where n is the length of the string and k the number of words.

```
public static List<Integer> findSubstring(String s, String[] words) {
    List<Integer> indexes = new LinkedList<>();
    HashMap<String, Integer> frequency = new HashMap<>();
    HashMap<String, Integer> frequencyTmp;

    int left;
    int right;
    int uniqueCounter = 0;
    int tmpUniqueCounter;

    if(words.length < 1){
        return indexes;
    }

    int wordSize = words[0].length();
    int windowSize = words.length * wordSize;

    // fill in frequency map
    for ( String word : words) {
        if(frequency.containsKey(word)) {
            frequency.replace(word, frequency.get(word) + 1 );
        } else {
            frequency.put(word, 1);
            uniqueCounter++;
        }
    }

    for (int i = 0; i < wordSize; i++) {
        left = i;
        right = i;
        frequencyTmp = new HashMap<>(frequency);
        tmpUniqueCounter = uniqueCounter;

        while(right + wordSize -1 < s.length()){
            String lastWord = s.substring(right, right+wordSize);
            if(frequencyTmp.containsKey(lastWord)){
                frequencyTmp.replace(lastWord, frequencyTmp.get(lastWord) - 1);
                if(frequencyTmp.get(lastWord) == 0) {
                    tmpUniqueCounter--;
                }
            }
            if(right + wordSize - left == windowSize){
                if(tmpUniqueCounter == 0){
                    indexes.add(left);
                }
                String firstWord = s.substring(left, left+wordSize);
                if(frequencyTmp.containsKey(firstWord)){
                    frequencyTmp.replace(firstWord, frequencyTmp.get(firstWord) + 1);
                    if(frequencyTmp.get(firstWord) > 0) {
                        tmpUniqueCounter++;
                    }
                }
                left += wordSize;
            }
            right += wordSize;
        }
    }
    return indexes;
}
```
