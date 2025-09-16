class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Stack<Integer> stack = new Stack<>();

        for (int x : nums) {
            while (!stack.isEmpty() && gcd(stack.peek(), x) > 1) {
                int y = stack.pop();
                x = lcm(x, y);
            }
            stack.push(x);
        }

        return new ArrayList<>(stack);
    }

    int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    int lcm(int a, int b) {
        return (int)((long) a * b / gcd(a, b));
    }
}