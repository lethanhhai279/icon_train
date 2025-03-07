import java.util.Arrays;
public class SortArray {

	public static String sortCaseInsensitive(String input){
    	if(input==null || input.isEmpty()){
        	return input;
        }
        
        Character[] chars = new Character[input.length()];
        
        for (int i=0; i<input.length(); i++){
        	chars[i] = input.charAt(i);
        }
        System.out.println(chars); 
        Arrays.sort(chars, (a,b)->{
        	char lowerA = Character.toLowerCase(a);
            char lowerB = Character.toLowerCase(b);
            
            if(lowerA == lowerB){
            	return a-b;
            }
            return lowerA - lowerB;
        });
        StringBuilder result = new StringBuilder();
        for (Character c: chars){
        	result.append(c);
        }
        return result.toString();
    }


  	public static void main(String[] args) {
      String input = "DdAaCcbB";
        String output = sortCaseInsensitive(input);
        System.out.println("Input = " + input);
        System.out.println("Output = " + output);
    }
}

