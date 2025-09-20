public class Main {
    public static void main(String[] args) {
        DynamicArray<String> arr = new DynamicArray<>();

        arr.add("A");
        arr.add("B");
        arr.add("C");

        System.out.println("Elements at index 1: " + arr.get(1));

        System.out.println("Removed:" + arr.remove(1));
        
        System.out.println("Remaining elements: ");
        for (int i = 0; i < arr.size(); i++) {
            if (i > 0){
                System.out.print(" ");
            }
            System.out.print(arr.get(i));
        }
        System.out.println();

        for (int i = 0; i < 20; i++) {
            arr.add("X"+i);
        }
        System.out.println("size=" + arr.size());
    }    
}
