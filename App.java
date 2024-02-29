package org.example;

/**
 * Hello world!
 *
 */
import java.util.*;

public class App {

    public static void main(String[] args) {
        Map<String, Object> nestedObject = new HashMap<>();
        nestedObject.put("key1", "value1");
        nestedObject.put("key2", "value2");

        Map<String, Object> innerObject = new HashMap<>();
        innerObject.put("innerKey1", "innerValue1");
        innerObject.put("innerKey2", "innerValue2");

        nestedObject.put("key3", innerObject);

        // Call the function to obtain key references
        List<String> keyReferences = getKeyReferences(nestedObject, "");

        // Print key references
        for (String keyRef : keyReferences) {
            System.out.println(keyRef);
        }
    }

    public static List<String> getKeyReferences(Map<String, Object> nestedObject, String currentPath) {
        List<String> keyReferences = new ArrayList<>();

        for (Map.Entry<String, Object> entry : nestedObject.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            String fullPath = currentPath.isEmpty() ? key : currentPath + "." + key;

            if(key.contains("1"))
            keyReferences.add(fullPath);

            if (value instanceof Map) {
                keyReferences.addAll(getKeyReferences((Map<String, Object>) value, fullPath));
            }
        }

        return keyReferences;
    }
}
