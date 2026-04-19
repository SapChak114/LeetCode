import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currentLine = new ArrayList<>();
        int runningLen = 0; // Tracks length of words + minimum required spaces

        // ==========================================
        // Phase 1: Pack lines
        // ==========================================
        for (String word : words) {
            // Equivalent to Python's: (1 if line else 0)
            int requiredSpace = currentLine.isEmpty() ? 0 : 1; 

            // if running_len + req_space + len(word) <= maxWidth:
            if (runningLen + requiredSpace + word.length() <= maxWidth) {
                currentLine.add(word); // add word to line
                runningLen += requiredSpace + word.length();
            } else {
                // finalise(line)
                result.add(justify(currentLine, maxWidth, false));
                
                // start new line with word
                currentLine.clear();
                currentLine.add(word);
                runningLen = word.length();
            }
        }
        // finalise(last_line)
        result.add(justify(currentLine, maxWidth, true));

        return result;
    }

    // ==========================================
    // Phase 2: justify each line
    // ==========================================
    private String justify(List<String> line, int maxWidth, boolean isLast) {
        int numWords = line.size();
        StringBuilder sb = new StringBuilder();

        // Calculate sum(len(w) for w in words)
        int charsLen = 0;
        for (String w : line) charsLen += w.length();

        // if is_last or len(words) == 1: left-justify
        if (isLast || numWords == 1) {
            // Python: " ".join(words)
            sb.append(String.join(" ", line)); 
            
            // Python: .ljust(maxWidth)
            while (sb.length() < maxWidth) {
                sb.append(" ");
            }
            return sb.toString();
        }

        // spare = maxWidth - sum(len(w) for w in words)
        int spare = maxWidth - charsLen;
        int gaps = numWords - 1;

        // base, extra = divmod(spare, len(words) - 1)
        int base = spare / gaps;   // base spaces for every gap
        int extra = spare % gaps;  // leftover spaces to give to the left

        // Construct the line string
        for (int i = 0; i < numWords; i++) {
            sb.append(line.get(i));
            
            // Apply spaces to the gaps (not after the final word)
            if (i < gaps) {
                // extra left-gaps get base+1, rest get base
                int spacesToApply = base + (i < extra ? 1 : 0);
                
                for (int j = 0; j < spacesToApply; j++) {
                    sb.append(" ");
                }
            }
        }

        return sb.toString();
    }
}