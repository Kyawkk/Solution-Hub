import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number: ");
        String n = input.next();
        sumUp(n);
    }
    public static void sumUp(String n){
         int value =0;
        if (n.length()>1){
            for (int i=0; i<n.length(); i++){
                value+= Character.getNumericValue(n.charAt(i));
            }
        }
        if (Integer.toString(value).length()>1){
            sumUp(Integer.toString(value));
        }
        else {
            System.out.println(value);
        }
    }
}
