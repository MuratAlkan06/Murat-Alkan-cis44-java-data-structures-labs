import org.junit.Test;
import static org.junit.Assert.*;

public class IntelligentCacheTest {

    @Test
    public void testEmptyCacheBehavior() {
        IntelligentCache cache = new IntelligentCache(2);

        assertTrue(cache.isEmpty());
        assertEquals(0, cache.size());
        assertNull(cache.get(999));
        assertFalse(cache.containsKey(999));
    }

    @Test
    public void testPutAndGet() {
        IntelligentCache cache = new IntelligentCache(2);

        cache.put(1, "A");
        cache.put(2, "B");

        assertEquals("A", cache.get(1));
        assertEquals("B", cache.get(2));
        assertTrue(cache.containsKey(1));
        assertTrue(cache.containsKey(2));
        assertEquals(2, cache.size());
        assertFalse(cache.isEmpty());
    }

    @Test
    public void testUpdateExistingKeyDoesNotIncreaseSize() {
        IntelligentCache cache = new IntelligentCache(2);

        cache.put(1, "A");
        cache.put(1, "A2");

        assertEquals("A2", cache.get(1));
        assertEquals(1, cache.size());
    }

    @Test
    public void testEvictionLeastRecentlyUsed() {
        IntelligentCache cache = new IntelligentCache(3);

        cache.put(1, "A");
        cache.put(2, "B");
        cache.put(3, "C");

        assertEquals("A", cache.get(1));

        cache.put(4, "D");

        assertNull(cache.get(2));
        assertNotNull(cache.get(3));
        assertNotNull(cache.get(4));
    }

    @Test
    public void testRecencyUpdatedOnGet() {
        IntelligentCache cache = new IntelligentCache(2);

        cache.put(1, "A");
        cache.put(2, "B");

        assertEquals("A", cache.get(1));

        cache.put(3, "C");

        assertNotNull(cache.get(1));
        assertNull(cache.get(2));
        assertNotNull(cache.get(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidCapacityThrows() {
        new IntelligentCache(0);
    }
}
