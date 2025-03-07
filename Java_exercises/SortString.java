import java.util.Arrays;
public class SortString {
  public static void main(String[] args) {
    String name = "AB21C3";
    char[] myArr = name.toCharArray();
    Arrays.sort(myArr);
    
    StringBuilder letters = new StringBuilder();
    StringBuilder digits = new StringBuilder();
     
    for (char i: myArr){
    	if(Character.isLetter(i)){
        	letters.append(i);
		}
        if(Character.isDigit(i)){
        	digits.append(i);
		}
    }
    String out =  letters.toString() + digits.toString();
    System.out.println(out);
  }
}
