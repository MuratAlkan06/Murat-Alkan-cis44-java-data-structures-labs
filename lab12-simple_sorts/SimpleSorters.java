import java.util.Comparator;

public class SimpleSorters {

    public static <T> void bubbleSort(T[] array, Comparator<T> comparator) {
        int lengthOfArray = array.length;
        for (int passIndex = 0; passIndex < lengthOfArray - 1; passIndex++) {
            boolean didSwapOnThisPass = false;
            for (int currentIndex = 0; currentIndex < lengthOfArray - passIndex - 1; currentIndex++) {
                int nextIndex = currentIndex + 1;
                if (comparator.compare(array[currentIndex], array[nextIndex]) > 0) {
                    T temporaryValue = array[currentIndex];
                    array[currentIndex] = array[nextIndex];
                    array[nextIndex] = temporaryValue;
                    didSwapOnThisPass = true;
                }
            }
            if (!didSwapOnThisPass) {
                break;
            }
        }
    }

    public static <T> void insertionSort(T[] array, Comparator<T> comparator) {
        int lengthOfArray = array.length;
        for (int indexToInsert = 1; indexToInsert < lengthOfArray; indexToInsert++) {
            T valueToInsert = array[indexToInsert];
            int previousIndex = indexToInsert - 1;
            while (previousIndex >= 0 && comparator.compare(array[previousIndex], valueToInsert) > 0) {
                array[previousIndex + 1] = array[previousIndex];
                previousIndex--;
            }
            array[previousIndex + 1] = valueToInsert;
        }
    }
}