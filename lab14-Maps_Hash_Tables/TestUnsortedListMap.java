public class TestUnsortedListMap {
    public static void main(String[] args) {
        UnsortedListMap<Integer, String> map = new UnsortedListMap<>();

        System.out.println(map.put(5, "A")); // null
        System.out.println(map.put(7, "B")); // null
        System.out.println(map.put(2, "C")); // null
        System.out.println(map.put(2, "E")); // C  (value replacement)
        System.out.println(map.get(7));      // B
        System.out.println(map.remove(5));   // A
    }
}
