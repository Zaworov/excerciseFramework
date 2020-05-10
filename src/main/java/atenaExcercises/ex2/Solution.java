package atenaExcercises.ex2;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import sun.awt.SunHints;

import java.util.*;
import java.util.Map.Entry;

interface TimeProvider {
    long getMillis();
}

class CachingDataStructure implements TimeProvider {
    static final Logger log = LoggerFactory.getLogger(CachingDataStructure.class);
    private int maxSize;
    private long lowestTimeToLeave = 0;
    private LinkedHashMap<String, ValueObject> VALUES_MAP = new LinkedHashMap<>();

    CachingDataStructure(int maxSize) {
        this.maxSize = maxSize;
    }

    public void put(String key, String value, long timeToLeaveInMilliseconds) {
        setLowestTimeToLeave(timeToLeaveInMilliseconds);

        //        cleanTheMap(); // TODO Retrieve this

        ValueObject valueObject = new ValueObject(value, timeToLeaveInMilliseconds);
        if (VALUES_MAP.size() == maxSize) {
            System.out.println("REACHED MAX CAPACITY");
            if (!VALUES_MAP.containsKey(key)) {
                if (timeToLeaveInMilliseconds > lowestTimeToLeave) {
                    System.out.println("REPLACING THE LOWEST (" + lowestTimeToLeave + ") with " + timeToLeaveInMilliseconds);
                    replaceTheLowest(key, valueObject);
                    return;
                } else {
                    System.out.println("CAN'T ADD - CAPACITY IS FULL");
                    return;
                }
            } else if (VALUES_MAP.containsKey(key)) {
                System.out.println("REPLACE");
                long newTimeToLeave = valueObject.getTimeToLeaveInMilliseconds();
                if (newTimeToLeave > VALUES_MAP.get(key).getTimeToLeaveInMilliseconds()) {
                    VALUES_MAP.put(key, valueObject);
                }
            }
        }
        VALUES_MAP.put(key, valueObject);
    }

    private void setLowestTimeToLeave(long timeToLeaveInMilliseconds) {
        if (lowestTimeToLeave == 0) {
            lowestTimeToLeave = timeToLeaveInMilliseconds;
        } else if (timeToLeaveInMilliseconds < lowestTimeToLeave) {
            System.out.println("NOT ADDING, TIME IS " + timeToLeaveInMilliseconds + " LOWER THEN THE LOWEST: " + lowestTimeToLeave);
        }
    }

    private void replaceTheLowest(String key, ValueObject valueObject) {
        String lowestKey = (String) findTheLowest().getKey();
        VALUES_MAP.remove(lowestKey);
        put(key, valueObject.getValue(), valueObject.getTimeToLeaveInMilliseconds());
        ValueObject lowestValueObject = (ValueObject) findTheLowest().getValue();
        lowestTimeToLeave = lowestValueObject.getTimeToLeaveInMilliseconds();
    }

    private Entry findTheLowest() {
        Iterator<Entry<String, ValueObject>> iterator = VALUES_MAP.entrySet().iterator();
        long lowestTime = 0;
        Entry resultEntry = null;
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (resultEntry == null) resultEntry = entry;
            ValueObject currentValueObject = (ValueObject) entry.getValue();
            long currentTimeToLeave = currentValueObject.getTimeToLeaveInMilliseconds();
            if (lowestTime == 0) lowestTime = currentTimeToLeave;
            if (currentTimeToLeave < lowestTime) {
                lowestTime = currentTimeToLeave;
                resultEntry = entry;
            }
        }
        return resultEntry;
    }

    private void isLowestTimeToLeave(long timeToLeaveInMilliseconds, HashMap<String, ValueObject> values_map) {
    }

    private void cleanTheMap() {
        System.out.println("CLEANING");
        for (String key : VALUES_MAP.keySet()) {
            ValueObject valueObject = VALUES_MAP.get(key);
            if (getMillis() >= valueObject.getTimeToLeaveInMilliseconds()) {
                VALUES_MAP.remove(key);
            }
        }
    }

//    private long getLowestTimeToLeave() {
//        Object[] array = new Collection[]{VALUES_MAP.values()};
//        Arrays.sort(array);
//        return (long) array[0];
//    }

    public int getValuesMapSize() {
//        cleanTheMap(); //TODO Retrieve later
        return VALUES_MAP.size();
    }

    @Override
    public long getMillis() {
        return System.currentTimeMillis();
    }

    public long getLowestTimeToLeave() {
        return lowestTimeToLeave;
    }

    private class ValueObject {
        String value;
        long timeToLeaveInMilliseconds;

        public ValueObject(String value, long timeToLeaveInMilliseconds) {
            this.value = value;
            this.timeToLeaveInMilliseconds = timeToLeaveInMilliseconds;
        }

        String getValue() {
            return value;
        }

        long getTimeToLeaveInMilliseconds() {
            return timeToLeaveInMilliseconds;
        }
    }
}

