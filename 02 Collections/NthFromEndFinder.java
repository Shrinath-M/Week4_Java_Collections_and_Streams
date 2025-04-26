import java.util.LinkedList;

public class NthFromEndFinder {
    public static <T> T findNthFromEnd(LinkedList<T> list, int n) {
        if (list == null || n <= 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        var firstPointer = list.listIterator();
        var secondPointer = list.listIterator();
        for (int i = 0; i < n; i++) {
            if (firstPointer.hasNext()) {
                firstPointer.next();
            } else {
                throw new IllegalArgumentException("N is larger than list size");
            }
        }

        while (firstPointer.hasNext()) {
            firstPointer.next();
            secondPointer.next();
        }

        return secondPointer.next();
    }

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");

        int n = 2;
        System.out.println("Nth element from the end: " + findNthFromEnd(linkedList, n));
    }
}
