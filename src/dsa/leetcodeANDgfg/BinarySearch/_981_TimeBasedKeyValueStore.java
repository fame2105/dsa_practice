package dsa.leetcodeANDgfg.BinarySearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// https://leetcode.com/problems/time-based-key-value-store/
public class _981_TimeBasedKeyValueStore {
    class TimeMap {

        private class Pair {
            String val;
            int timestamp;

            Pair(String val, int timestamp) {
                this.val = val;
                this.timestamp = timestamp;
            }
        }

        Map<String, List<Pair>> map;

        public TimeMap() {
            this.map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            List<Pair> list = map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(new Pair(value, timestamp));
        }

        public String get(String key, int timestamp) {
            List<Pair> list = map.getOrDefault(key, new ArrayList<>());
            if (list.size() > 0) {
                return getFloorValue(list, timestamp);
            }

            return "";
        }

        private String getFloorValue(List<Pair> list, int timestamp) {
            int lo = 0, hi = list.size() - 1;
            Pair ans = null;
            while (lo <= hi) {
                int mid = hi - (hi - lo) / 2;
                if (list.get(mid).timestamp <= timestamp) {
                    ans = list.get(mid);
                    if (list.get(mid).timestamp == timestamp) {
                        break;
                    }
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }

            return ans != null ? ans.val : "";
        }
    }
}
