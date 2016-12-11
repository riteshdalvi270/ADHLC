package Oct2016.snapchat;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by ritesh on 12/9/16.
 */
public class Cache {

    public static void main(String args[]) {

    }
}

class LFUCache {

    final Map<Integer,FrequencyValue> cacheValueByKey;
    final int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cacheValueByKey = new HashMap<>(capacity);
    }

    public int get(int key) {

        synchronized(this) {
            final FrequencyValue value = cacheValueByKey.get(key);

            if(value == null) {
                return -1;
            }

            value.incrementFrequency();
            value.setRecentToNow();

            return value.getValue();
        }
    }

    public void set(int key, int value) {

        synchronized(this) {

            if(cacheValueByKey.size() ==  capacity) {
                int leastUsedkey = theMostLeastFrequentlyRecentlyUsedKey(cacheValueByKey);
                cacheValueByKey.remove(leastUsedkey);
            }

            if(!cacheValueByKey.containsKey(key)) {
                final FrequencyValue frequencyValue = new FrequencyValue(value,0);
                cacheValueByKey.put(key,frequencyValue);
            }
        }
    }

    private int theMostLeastFrequentlyRecentlyUsedKey(final Map<Integer,FrequencyValue> cacheValueByKey) {

        int leastFrequentlyUsedValue = Integer.MAX_VALUE;
        int leastFrequentlyUsedKey=0;
        Instant leastRecentlyUsedValue = Instant.now();
        int leastRecentlyUsedkey = 0;

        for(Map.Entry<Integer,FrequencyValue> cacheEntries : cacheValueByKey.entrySet()) {

            int key = cacheEntries.getKey();
            FrequencyValue value = cacheEntries.getValue();

            if(value.getFrequency() < leastFrequentlyUsedValue) {
                leastFrequentlyUsedValue = value.getFrequency();
                leastFrequentlyUsedKey = key;

                if(leastRecentlyUsedkey!=0) {
                    leastRecentlyUsedkey = 0;
                }
            }else if(value.getFrequency() == leastFrequentlyUsedValue) {

                if(value.getRecent().isBefore(leastRecentlyUsedValue)) {
                    leastRecentlyUsedValue = value.getRecent();
                    leastRecentlyUsedkey = key;
                }
            }
        }


        if(leastRecentlyUsedkey!=0) {
            return leastRecentlyUsedkey;
        }

        return leastFrequentlyUsedKey;
    }
}

class FrequencyValue {
    private int frequency;
    private int value;
    private Instant dateTime;

    public FrequencyValue(int value,int frequency) {
        this.value = value;
        this.frequency = frequency;
        this.dateTime = Instant.now();
    }

    public int getValue() {
        return value;
    }

    public int getFrequency() {
        return frequency;
    }

    public Instant getRecent() {
        return dateTime;
    }

    public void incrementFrequency() {
        frequency = frequency + 1;
    }

    public void setRecentToNow() {
        dateTime = Instant.now();
    }
}