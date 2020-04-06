package atenaExcercises.ex2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    private CachingDataStructure cachingDataStructure;

    @Test
    public void putTest() {
        //given
        cachingDataStructure = new CachingDataStructure(1);

        //when
        cachingDataStructure.put("key", "value", 5);
        int collectionSize = cachingDataStructure.getValuesMapSize();

        //then
        assertEquals(1, collectionSize);
    }

    @Test
    public void putAboveSizeLimit() {
        //given
        cachingDataStructure = new CachingDataStructure(1);

        //when
        cachingDataStructure.put("key", "value", 5);
        cachingDataStructure.put("key2", "value2", 5);
        int collectionSize = cachingDataStructure.getValuesMapSize();

        //then
        assertEquals(1, collectionSize);
    }

    @Test
    public void sameValueReplacementTest() {
        //given
        cachingDataStructure = new CachingDataStructure(2);

        //when
        cachingDataStructure.put("key", "value", 5);
        cachingDataStructure.put("key", "value2", 5);
        cachingDataStructure.put("key2", "value3", 5);
        int collectionSize = cachingDataStructure.getValuesMapSize();

        //then
        assertEquals(2, collectionSize);
    }

    @Test
    public void addingLowestTimeToLeaveTest() {
        //given
        cachingDataStructure = new CachingDataStructure(5);

        //when
        cachingDataStructure.put("key", "value", 5);
        cachingDataStructure.put("key2", "value2", 6);
        cachingDataStructure.put("key3", "value3", 3);
        long lowestTimeToLeave = cachingDataStructure.getLowestTimeToLeave();

        //then
        assertEquals(5, lowestTimeToLeave);
    }

}