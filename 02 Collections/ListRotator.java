import java.util.*;

public class ListRotator {
    public static <T> List<T> rotateList(List<T> list, int positions) {
        int size = list.size();
        positions = positions % size;

        List<T> rotatedList = new ArrayList<>();
        rotatedList.addAll(list.subList(positions, size));
        rotatedList.addAll(list.subList(0, positions));

        return rotatedList;
    }

    public static void main(String[] args) {
        List<Integer> inputList = Arrays.asList(10, 20, 30, 40, 50);
        int rotateBy = 2;

        System.out.println("Original List: " + inputList);
        List<Integer> rotatedList = rotateList(inputList, rotateBy);
        System.out.println("Rotated List: " + rotatedList);
    }
}

