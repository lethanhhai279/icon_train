import java.util.Arrays;

public class NotDuplicate {
    public static void main(String[] args) {
    int[] myArr = {1, 5, 7, 5, 4, 3, 4, 4};
    
    int[] result = Arrays.stream(myArr)  // Convert int[] to IntStream
                         .distinct()      // Remove duplicates
                         .toArray();      // Convert back to int[]
    Arrays.sort(result);
    System.out.println(Arrays.toString(result)); 
  }
}
