class Bank {
    long[] balance;
    public Bank(long[] balance) {
        this.balance = balance;
    }
    
    public boolean transfer(int from, int to, long m) {
        from -= 1;
        to -= 1;
        if (from >= balance.length || to >= balance.length) {
            return false;
        }
        if (balance[from] >= m) {
            balance[to] += m;
            balance[from] -= m;
            return true;
        }
        return false;
    }
    
    public boolean deposit(int ac, long m) {
        ac -= 1;
        if (ac >= balance.length) {
            return false;
        }
        if (m >= 0) {
            balance[ac] += m;
            return true;
        }

        return false;
    }
    
    public boolean withdraw(int ac, long m) {
        ac -= 1;
        if (ac >= balance.length) {
            return false;
        }
        if (balance[ac] >= m) {
            balance[ac] -= m;
            return true;
        }

        return false;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */