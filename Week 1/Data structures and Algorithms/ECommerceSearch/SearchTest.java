import java.util.Arrays;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P001", "Laptop", "Electronics"),
            new Product("P003", "Tablet", "Electronics"),
            new Product("P002", "Smartphone", "Electronics"),
            new Product("P004", "Monitor", "Electronics")
        };
        
        System.out.println("Linear Search for P002:");
        System.out.println(SearchAlgorithms.linearSearch(products, "P002"));
        
        Arrays.sort(products); // binary search requires sorted array
        
        System.out.println("\nBinary Search for P003:");
        System.out.println(SearchAlgorithms.binarySearch(products, "P003"));
    }
}