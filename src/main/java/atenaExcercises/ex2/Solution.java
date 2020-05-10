package atenaExcercises.ex2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.Map.Entry;

interface TimeProvider {
    long getMillis();
}

class CachingDataStructure implements TimeProvider {
    static Logger logger = LoggerFactory.getLogger(CachingDataStructure.class);
    private int maxSize;
    private long lowestTimeToLeave = 0;
    private LinkedHashMap<String, ValueObject> VALUES_MAP = new LinkedHashMap<>();

    CachingDataStructure(int maxSize) {
        this.maxSize = maxSize;
    }

    public void put(String key, String value, long timeToLeaveInMilliseconds) {
        verifyInput(key, value);
//        long currentTime = getMillis(); //TODO add it when cleanTheMap works fine and is tested
//        if (timeToLeaveInMilliseconds <= currentTime) {
//            System.out.println("NOT ADDING - time to leave equal or lower then current time");
//            cleanTheMap(currentTime);
//            return;
//        }
        setLowestTimeToLeave(timeToLeaveInMilliseconds);

        ValueObject valueObject = new ValueObject(value, timeToLeaveInMilliseconds);
        if (VALUES_MAP.size() == maxSize) {
            if (!VALUES_MAP.containsKey(key)) {
                if (timeToLeaveInMilliseconds > lowestTimeToLeave) {
                    replaceTheLowest(key, valueObject);
                    return;
                } else {
                    return;
                }
            } else if (VALUES_MAP.containsKey(key)) {
                long newTimeToLeave = valueObject.getTimeToLeaveInMilliseconds();
                if (newTimeToLeave > VALUES_MAP.get(key).getTimeToLeaveInMilliseconds()) {
                    VALUES_MAP.put(key, valueObject);
                }
            }
        }
        VALUES_MAP.put(key, valueObject);
//        cleanTheMap(currentTime);
    }

    private void verifyInput(String key, String value) {
        if (key == null || value == null){
            throw new IllegalArgumentException("Either key or value is null");
        }
    }

    private void setLowestTimeToLeave(long timeToLeaveInMilliseconds) {
        if (lowestTimeToLeave == 0) {
            lowestTimeToLeave = timeToLeaveInMilliseconds;
        } else if (timeToLeaveInMilliseconds < lowestTimeToLeave) {
            logger.info("NOT ADDING, TIME IS {} LOWER THEN THE LOWEST {}", timeToLeaveInMilliseconds, lowestTimeToLeave);
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

    public long getLowestTimeToLeave() {
        return lowestTimeToLeave;
    }

    private void cleanTheMap(long currentTime) {
        for (String key : VALUES_MAP.keySet()) {
            ValueObject valueObject = VALUES_MAP.get(key);
            if (valueObject.getTimeToLeaveInMilliseconds() <= currentTime ) {
                VALUES_MAP.remove(key);
            }
        }
    }

    public int getValuesMapSize() {
//        cleanTheMap();
        return VALUES_MAP.size();
    }

    @Override
    public long getMillis() {
        return System.currentTimeMillis();
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

