class TimeMap {
    class Pair {
        String val;
        int time;

        Pair(String val, int time) {
            this.val = val;
            this.time = time;
        }
    }

    HashMap<String, List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(new Pair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        List<Pair> pList = map.get(key);

        if (pList == null || pList.isEmpty()) {
            return "";
        }

        int idx = bs(pList, timestamp);

        if (idx == -1) {
            return "";
        }

        return pList.get(idx).val;
    }

    int bs(List<Pair> pList, int timestamp) {

        int l = 0, r = pList.size() - 1, ans = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (pList.get(mid).time <= timestamp) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return ans;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */