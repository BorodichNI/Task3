package Task3;

import java.util.*;

public class ProductSorting {

    public static Map<String, Long> creatMap() {
        HashMap<String, Long> cutomersAndProducts = new HashMap<>();
        cutomersAndProducts.put("c1", 1L);
        cutomersAndProducts.put("c2", 15L);
        cutomersAndProducts.put("c3", 99L);
        cutomersAndProducts.put("c4", 1500L);
        cutomersAndProducts.put("c5", 25L);
        cutomersAndProducts.put("c6", 70L);
        return cutomersAndProducts;
    }

    public static List<List<String>> cutomersToProductsCount(Map<String, Long> cutomersAndProducts, Long productsThreshold) {
        List<List<String>> result = new ArrayList<>();
        List<String> intermediate = new ArrayList<>();
        long sumValue = 0;

        for (Map.Entry<String, Long> entry : cutomersAndProducts.entrySet()) {
            if (intermediate.isEmpty() || sumValue + entry.getValue() < productsThreshold) {
                intermediate.add(entry.getKey());
                sumValue += entry.getValue();

            } else {
                result.add(intermediate);
                intermediate = new ArrayList<>();
                intermediate.add(entry.getKey());
                sumValue = entry.getValue();

            }

        }
        result.add(intermediate);
        return result;
    }

    public static void main(String[] args) {
        for (List<String> str : cutomersToProductsCount(creatMap(), 100L)) {
            System.out.println(str);
        }
    }
}