import java.util.*;

public class SymmetricDifference {
    public static <T> Set<T> getSymmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> differenceSet = new HashSet<>(set1);
        differenceSet.addAll(set2);

        Set<T> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);

        differenceSet.removeAll(intersectionSet);
        return differenceSet;
    }

    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(3, 4, 5));

        System.out.println("Symmetric Difference: " + getSymmetricDifference(set1, set2));
    }
}
