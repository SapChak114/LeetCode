class Solution {
    int[] cards;
    public boolean judgePoint24(int[] cards) {
        this.cards = cards;
        List<Double> cardList = new ArrayList<>();
        for (double card : cards) {
            cardList.add(card);
        }
        return backtrack(cardList);
    }
    
    boolean backtrack(List<Double> cardList) {
        if (cardList.size() == 1) {
            return (Math.abs(cardList.get(0) - 24d)) <= 0.001; //1e-5
        }
        
        for (int i = 0; i<cardList.size(); i++) {
            for (int j = 0; j<cardList.size(); j++) {
                if (i == j) {
                    continue;
                }
                double a = cardList.get(i);
                double b = cardList.get(j);
                double[] vals = {a+b, a-b, b-a, a/b, b/a, a*b};
                List<Double> newList = new ArrayList<>();
                for (int k = 0; k<cardList.size(); k++) {
                    if (i == k || j == k) {
                        continue;
                    }
                    newList.add(cardList.get(k));
                }
                for (double val : vals) {
                    newList.add(val);
                    if (backtrack(newList)) {
                        return true;
                    }
                    newList.remove(newList.size()-1);
                }
            }
        }
        
        return false;
    }
}
