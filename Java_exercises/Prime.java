import java.util.ArrayList;

public class Prime {
    public static void main(String[] agrs){
        int[] myArr ={1, 2, 4, 5, 7, 12, 20};
        ArrayList<Integer> result = new ArrayList<>();
        for (int i: myArr){
            if (i < 2){
                continue;
            }
            boolean isPrime = true;
            for (int j=2; j < i; j++){
                if (i%j == 0){
                    isPrime = false;
                }
            }
            if (isPrime){
                result.add(i);
            }
        }
        System.out.println(result);
    }

}
