import java.util.HashMap;
import java.util.Map;

public class Solution {
    private static final int MOD = 1_000_000_007;
    private Map<Integer, Integer> dpMemo = new HashMap<>();
    private Map<Integer, Integer> dp2Memo = new HashMap<>();

    public int numTilings(int n) {
        return dp(n);
    }

    private int dp(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        if (n == 2) return 2;

        if (dpMemo.containsKey(n)) return dpMemo.get(n);

        long res = (dp(n - 1) + dp(n - 2)) % MOD;
        res = (res + 2L * dp2(n - 1)) % MOD;

        dpMemo.put(n, (int) res);
        return (int) res;
    }

    private int dp2(int n) {
        if (n <= 1) return 0;

        if (dp2Memo.containsKey(n)) return dp2Memo.get(n);

        long res = (dp2(n - 1) + dp(n - 2)) % MOD;

        dp2Memo.put(n, (int) res);
        return (int) res;
    }
}
