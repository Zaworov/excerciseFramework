package atenaExcercises.ex2;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import java.sql.Time;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;

interface TimeProvider {
    long getMillis();
}

class CachingDataStructure implements TimeProvider {
    static final Logger log = LoggerFactory.getLogger(CachingDataStructure.class);
    private int maxSize;
    private static long lowestTimeToLeave = 0;
    private HashMap<String, ValueObject> VALUES_MAP = new HashMap<>();

    CachingDataStructure(int maxSize) {
        this.maxSize = maxSize;
    }

    public void put(String key, String value, long timeToLeaveInMilliseconds) {
        if (lowestTimeToLeave == 0) {
            lowestTimeToLeave = timeToLeaveInMilliseconds;
        } else if (timeToLeaveInMilliseconds < lowestTimeToLeave) {
            return;
        }

//        cleanTheMap(); // TODO Retrieve this
        ValueObject valueObject = new ValueObject(value, timeToLeaveInMilliseconds);
        if (VALUES_MAP.size() == maxSize && !VALUES_MAP.containsKey(key)) {
            System.out.println("CAN'T ADD ENTRY - VALUE MAP IS FULL");
            //TODO Add log - "MAP IS FULL"
            return;
        } else if (VALUES_MAP.size() == maxSize && VALUES_MAP.containsKey(key)){
            System.out.println("REPLACE");
            long newTimeToLeave = valueObject.getTimeToLeaveInMilliseconds();
            if (newTimeToLeave > VALUES_MAP.get(key).getTimeToLeaveInMilliseconds()){
                VALUES_MAP.put(key, valueObject);
            }
        }

//        long lowestTimeToLeave = getLowestTimeToLeave();
//        if (timeToLeaveInMilliseconds < lowestTimeToLeave) {
//            //TODO Add log - "NOT ADDING AS HAS LOWER TIME TO LEAVE THEN LOWEST IN COLLECTION
//            return;
//        }

        VALUES_MAP.put(key, valueObject);
    }

    private void isLowestTimeToLeave(long timeToLeaveInMilliseconds, HashMap<String, ValueObject> values_map) {
    }

    private void cleanTheMap() {
        System.out.println("CLEANING");
        for (String key : VALUES_MAP.keySet()){
            ValueObject valueObject = VALUES_MAP.get(key);
            if (getMillis() >= valueObject.getTimeToLeaveInMilliseconds()){
                VALUES_MAP.remove(key);
            }
        }
    }

//    private long getLowestTimeToLeave() {
//        Object[] array = new Collection[]{VALUES_MAP.values()};
//        Arrays.sort(array);
//        return (long) array[0];
//    }

    public Optional<String> get(String key) {
        cleanTheMap();
        Optional<String> optional = Optional.ofNullable(key);
        return optional;
    }

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

        public ValueObject(String value, long timeToLeaveInMilliseconds){
            this.value = value;
            this.timeToLeaveInMilliseconds = timeToLeaveInMilliseconds;
        }

        String getValue (){
            return value;
        }

        long getTimeToLeaveInMilliseconds (){
            return timeToLeaveInMilliseconds;
        }
    }
}

