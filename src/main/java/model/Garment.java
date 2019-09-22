package model;

import lombok.Data;

import java.util.Map;

@Data
public class Garment implements Comparable {

    private static final Map<String, Integer> SIZE_VALUS_MAP =
            Map.of("XSS", 1,
                    "XS", 2,
                    "S", 3,
                    "M", 4,
                    "L", 5,
                    "XL", 6,
                    "XLL", 7);

    private String brand = "Unknown", type = "Unknown", size = "Unknown", color = "Unknown";

    @Override
    public int compareTo(Object o) {
        Garment otherGarment = (Garment) o;
        return Integer.compare(SIZE_VALUS_MAP.get(size), SIZE_VALUS_MAP.get(otherGarment.size));
    }

    @Override
    public String toString() {
        String garment = "";
        garment = appendToStringAndFormat(garment, brand);
        garment = appendToStringAndFormat(garment, type);
        garment = appendToStringAndFormat(garment, size);
        garment = appendToStringAndFormat(garment, color);

        return garment;
    }

    private String appendToStringAndFormat(String originalString, String stringToAdd) {
        String result = originalString + stringToAdd;
        int nmbrOfSpaces = 16 - stringToAdd.length();
        for (int i = 0; i < nmbrOfSpaces; i++) {
            result += " ";
        }
        return result;
    }
}
