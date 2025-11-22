import java.util.Arrays;
import java.util.Comparator;

public class SimpleSortDriver {
    public static void main(String[] args) {
        Comparator<Integer> integerComparator = Comparator.naturalOrder();

        Integer[] unsortedArray = {5, 1, 9, 3, 7, 6};
        Integer[] unsortedArrayCopy = Arrays.copyOf(unsortedArray, unsortedArray.length);

        System.out.println("--- Test 1: Unsorted Array ---");
        System.out.println("Original: " + Arrays.toString(unsortedArray));
        SimpleSorters.bubbleSort(unsortedArray, integerComparator);
        System.out.println("Bubble Sort: " + Arrays.toString(unsortedArray));

        System.out.println("Original: " + Arrays.toString(unsortedArrayCopy));
        SimpleSorters.insertionSort(unsortedArrayCopy, integerComparator);
        System.out.println("Insertion Sort: " + Arrays.toString(unsortedArrayCopy));

        Integer[] reverseSortedArray = {9, 7, 6, 5, 3, 1};
        Integer[] reverseSortedArrayCopy = Arrays.copyOf(reverseSortedArray, reverseSortedArray.length);

        System.out.println("\n--- Test 2: Reverse-Sorted Array ---");
        System.out.println("Original: " + Arrays.toString(reverseSortedArray));
        SimpleSorters.bubbleSort(reverseSortedArray, integerComparator);
        System.out.println("Bubble Sort: " + Arrays.toString(reverseSortedArray));

        System.out.println("Original: " + Arrays.toString(reverseSortedArrayCopy));
        SimpleSorters.insertionSort(reverseSortedArrayCopy, integerComparator);
        System.out.println("Insertion Sort: " + Arrays.toString(reverseSortedArrayCopy));

        Integer[] alreadySortedArray = {1, 2, 3, 4, 5, 6};
        Integer[] alreadySortedArrayCopy = Arrays.copyOf(alreadySortedArray, alreadySortedArray.length);

        System.out.println("\n--- Test 3: Already-Sorted Array ---");
        System.out.println("Original: " + Arrays.toString(alreadySortedArray));
        SimpleSorters.bubbleSort(alreadySortedArray, integerComparator);
        System.out.println("Bubble Sort: " + Arrays.toString(alreadySortedArray));

        System.out.println("Original: " + Arrays.toString(alreadySortedArrayCopy));
        SimpleSorters.insertionSort(alreadySortedArrayCopy, integerComparator);
        System.out.println("Insertion Sort: " + Arrays.toString(alreadySortedArrayCopy));
    }
}
