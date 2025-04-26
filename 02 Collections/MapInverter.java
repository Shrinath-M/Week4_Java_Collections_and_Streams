import java.util.*;

public class MapInverter {
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            invertedMap.computeIfAbsent(entry.getValue(), k -> new ArrayList<>()).add(entry.getKey());
        }

        return invertedMap;
    }

    public static void main(String[] args) {
        Map<String, Integer> inputMap = new HashMap<>();
        inputMap.put("A", 1);
        inputMap.put("B", 2);
        inputMap.put("C", 1);

        System.out.println("Original Map: " + inputMap);
        Map<Integer, List<String>> invertedMap = invertMap(inputMap);
        System.out.println("Inverted Map: " + invertedMap);
    }
}
