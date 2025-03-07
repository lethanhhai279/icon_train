public class LowestAge {
    static int findLowestAge(int[] myArr){
        int lowestAge = myArr[0];
        for (int a: myArr){
            if(a < lowestAge){
                lowestAge = a;
            }
        } 
        return lowestAge;
    }
    public static void main(String[] agrs){
        int[] myArr = {20, 22, 18, 35, 48, 26, 87, 70};
        System.out.println("lowest age: " + findLowestAge(myArr));
    }
}
