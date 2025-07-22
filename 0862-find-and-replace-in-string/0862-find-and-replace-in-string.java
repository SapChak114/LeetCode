class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = indices.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i<n; i++) {
            if (s.indexOf(sources[i], indices[i]) == indices[i]) {
                map.put(indices[i], i);        
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i<s.length(); i++) {
            if (map.containsKey(i)) {
                sb.append(targets[map.get(i)]);
                i += (sources[map.get(i)].length() - 1);
            } else {
                sb.append(s.charAt(i));
            }
        }
        
        return sb.toString();
    }
}

/**
Input: s = "abcd", indices = [0, 2], sources = ["aa", "cd"], targets = ["eee", "ffff"]

case 1 :

1st iteration sources/indices:-
indices[i] = 0
sources[i] = aa
if (s.indexOf(sources[i], indices[i]) == indices[i]) { 
    set.add(indices[i]);    
}


StringBuilder sb = new StringBuilder(s);
2nd iteration set :-
    sb.replace(index, target[index])
    
return sb.toString();

Input: s = "abcda", indices = [0, 2, 4], sources = ["aa", "cd", "a"], targets = ["eee", "ffff"]
 */