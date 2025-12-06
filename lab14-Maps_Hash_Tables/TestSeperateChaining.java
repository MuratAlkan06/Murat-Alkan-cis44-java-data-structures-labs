public class TestSeperateChaining {
    public static void main(String[] args) {
        SeparateChainingMap<String, String> map = new SeparateChainingMap<>();

        System.out.println("put(foo, A): " + map.put("foo", "A")); 
        System.out.println("put(ba, B): " + map.put("ba", "B"));   
        System.out.println("put(BB, C): " + map.put("BB", "C"));   

        System.out.println("get(foo): " + map.get("foo")); 
        System.out.println("get(ba): " + map.get("ba"));   
        System.out.println("get(BB): " + map.get("BB"));   

        System.out.println("remove(ba): " + map.remove("ba")); 
        System.out.println("get(ba): " + map.get("ba"));       
    }
}
