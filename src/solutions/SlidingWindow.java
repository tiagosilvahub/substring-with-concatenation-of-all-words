package src.solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class SlidingWindow implements Solution {
    @Override
    public List<Integer> findSubstring(String s, String[] words) {
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
}
