class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<List<String>> wordLine = new ArrayList<>();
        for(int i = 0; i<words.length;){
            List<String> word = new ArrayList<>();
            int size = 0;
            while(i < words.length && size + words[i].length() <= maxWidth){
                word.add(words[i]);
                size += words[i++].length() + 1;
            }
            wordLine.add(word);
        }

        int i = 0;
        List<String> ans = new ArrayList<>();
        while(i < wordLine.size()-1){
            
            List<String> word = wordLine.get(i++);
            int arrLen = word.size();
            int lineLen = String.join("", word).length();
            int spaces = maxWidth - lineLen;

            int equalSpaces = arrLen > 1 ? spaces / (arrLen-1) : 0;
            int extraSpaces = arrLen > 1 ? spaces % (arrLen-1) : spaces;

            StringBuilder sb = new StringBuilder();
            for(int j = 0; j<arrLen; j++){
                sb.append(word.get(j));

                if(j == arrLen-1 && sb.length() == maxWidth){
                    continue;
                }

                if(extraSpaces > 0){
                    if(j == arrLen-1){
                        sb.append(" ".repeat(extraSpaces));
                    } else {
                        sb.append(" ".repeat(equalSpaces+1));
                    }
                    extraSpaces--;
                } else{
                    sb.append(" ".repeat(equalSpaces));
                }
            }
            ans.add(sb.toString());
        }

        List<String> lastLine = wordLine.get(wordLine.size()-1);
        StringBuilder sb = new StringBuilder();
        for(i = 0; i<lastLine.size(); i++){
            String word = lastLine.get(i);
            sb.append(word);
            
            if(i == lastLine.size()-1){
                sb.append(" ".repeat(maxWidth-sb.length()));
                break;
            }
            sb.append(" ");
        }
        ans.add(sb.toString());

        return ans;
    }
}