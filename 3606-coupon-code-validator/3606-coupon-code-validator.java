class Solution {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        Set<String> set = Set.of("electronics", "grocery", "pharmacy", "restaurant");
        List<Pair<String, String>> codeS = new ArrayList<>();
        List<String> bl = new ArrayList<>();

        for (int i = 0; i<code.length; i++) {
            if (!set.contains(businessLine[i]) || !isActive[i] || !checkChar(code[i])) {
                //System.out.println("--"+code[i] + " " + businessLine[i] + " " + isActive[i]+"--");
                continue;
            }
            codeS.add(new Pair(code[i], businessLine[i]));
        }

        Collections.sort(codeS, (a, b) -> {
            if (((String)a.getValue()).compareTo(((String)b.getValue())) == 0) {
                return a.getKey().compareTo(((String)b.getKey()));
            } else {
                return ((String)a.getValue()).compareTo(((String)b.getValue()));
            }
        });
        
        List<String> ans = new ArrayList<>();
        for (int i = 0; i<codeS.size(); i++) {
            ans.add((String)codeS.get(i).getKey());
        }

        return ans;
    }

    boolean checkChar(String code) {
        if (code.isEmpty()) {
            return false;
        }
        char[] ch = code.toCharArray();

        for (char c : ch) {
            //System.out.print("before "+c+" ");
            if (!Character.isLetterOrDigit(c) && c != '_') {
                //System.out.println("after "+c+" ");
                return false;
            }
        }

        return true;
    }
}