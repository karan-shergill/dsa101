// https://leetcode.com/problems/time-based-key-value-store/description/

class TimeMap {


    HashMap<String, ArrayList<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            ArrayList<Pair<Integer, String>> list = new ArrayList<>();
            list.add(new Pair(timestamp, value));
            map.put(key, list);
        } else {
            ArrayList<Pair<Integer, String>> list = map.get(key);
            list.add(new Pair(timestamp, value));
            map.put(key, list);
        }
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }

        ArrayList<Pair<Integer, String>> list = map.get(key);
        int start = 0;
        int end = list.size() - 1;
        String pAns = "";

        while (start <= end) {
            int mid = start + (end - start)/2;

            if (list.get(mid).getKey() == timestamp) {
                return list.get(mid).getValue();
            } else if (list.get(mid).getKey() < timestamp) {
                pAns = list.get(mid).getValue();
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return pAns;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
