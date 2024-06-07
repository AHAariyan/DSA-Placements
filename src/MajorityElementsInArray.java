import java.util.HashMap;
import java.util.Map;

public class MajorityElementsInArray {
    public static void main(String[] args) {

        System.out.println(findTheElement(3, new int[]{3, 2, 3})); // Correct
        System.out.println(findTheElement(7, new int[]{2, 2, 1, 1, 1, 2, 2})); // Correct
        System.out.println(findTheElement(10, new int[]{4, 4, 2, 4, 3, 4, 4, 3, 2, 4})); // Correct

    }

    /**
     * Array: Length is fit on the memory
     * Length of the array: definite
     * Guaranteed there will be a result
     * Array will never be an empty array.
     */

    // Time : O(N^2) No Space
//    public static int findTheElement(int lengthOfArray, int[] numbers) {
//
//        int totalFrequencies = 1;
//        int number = numbers[0];
//
//
//        //{3,2,3} ->  3 -> 2 -> 0,1,2
//        for (int outerIndex = 0; outerIndex < lengthOfArray; outerIndex ++) {
//            int runningFrequencies = 0;
//            int pointerNumber = numbers[outerIndex];
//            for (int innerIndex = outerIndex + 1; innerIndex < lengthOfArray - 1; innerIndex ++) {
//
//                int runningNumber = numbers[innerIndex];
//                if (pointerNumber == runningNumber) {
//                    runningFrequencies ++;
//                }
//            }
//
//            // calculate the Frequency update and number update:
//            if (runningFrequencies > totalFrequencies) {
//                totalFrequencies = runningFrequencies;
//                number = pointerNumber;
//            }
//        }
//        return number;
//    }

    // Time: O(N) Space: O(N)
//    public static int findTheElement(int lengthOfArray, int[] numbers) {
//
//        Map<Integer, Integer> storeElements = new HashMap<>();
//
//        int totalFrequencies = 1;
//        int number = numbers[0];
//
//
//        //{3,2,3} ->  3 -> 2 -> 0,1,2
//        for (int index = 0; index < lengthOfArray; index++) {
//            storeElements.put(numbers[index], storeElements.getOrDefault(numbers[index], 0) + 1);
//        }
//
//        for (Map.Entry<Integer, Integer> mappedValue : storeElements.entrySet()) {
//            if (mappedValue.getValue() > totalFrequencies) {
//                totalFrequencies = mappedValue.getValue();
//                number = mappedValue.getKey();
//            }
//        }
//        return number;
//    }

    /**
     * BOYER and MOORE Algorithm
     * Time = 0(N) no space
     */
    public static int findTheElement(int lengthOfArray, int[] numbers) {

        int count = 0;
        int candidate = -1;

        for (int index = 0; index < numbers.length; index++) {
            if (count == 0) {
                candidate = numbers[index];
                count = 1;
            } else {
                if (candidate == numbers[index]) count++;
                else count--;
            }
        }

        count = 0;
        for (int index = 0; index < numbers.length; index ++) {
            if (candidate == numbers[index]) count ++;
        }

        if (count > numbers.length / 2) return candidate; else return -1;
    }
}
