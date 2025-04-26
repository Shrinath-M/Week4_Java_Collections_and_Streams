import java.util.*;

public class HashSetToSortedList {
    public static List<Integer> convertAndSort(Set<Integer> set) {
        List<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList); // Sorting in ascending order
        return sortedList;
    }

    public static void main(String[] args) {
        Set<Integer> inputSet = new HashSet<>(Arrays.asList(5, 3, 9, 1));

        System.out.println("Original Set: " + inputSet);
        List<Integer> sortedList = convertAndSort(inputSet);
        System.out.println("Sorted List: " + sortedList);
    }
}
