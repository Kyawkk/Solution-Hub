import java.util.ArrayList;
import java.util.Scanner;

public class Advanced {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String inputString = input.next();
        int oneOrMore = 0;
        char[] regArr = {'[','{','(',')','}',']'};
        ArrayList<formatModel> formatList = new ArrayList<>();
        formatList.add(new formatModel('[',']'));
        formatList.add(new formatModel('{','}'));
        formatList.add(new formatModel('(',')'));
        ArrayList<String> answersList = new ArrayList<>();
        ArrayList<Character> charOfInput = new ArrayList<>();

        for (int i=0; i<inputString.length(); i++){
            for (int j=0; j<regArr.length; j++){
                if (inputString.charAt(i)==regArr[j]){
                    charOfInput.add(inputString.charAt(i));
                }
            }
        }

        if (inputString.length()==1){
            answersList.add("YES");
        }

        else {
            for (int i=0; i<formatList.size(); i++){
                if (charOfInput.contains(formatList.get(i).getOpen())){
                    for (int j=0; j<charOfInput.size(); j++){
                        if (charOfInput.get(i).equals(charOfInput.get(j))){
                            oneOrMore++;
                        }
                    }
                    if (oneOrMore>1){
                        answersList.add("NO");
                    }
                    oneOrMore = 0;
                    if (charOfInput.contains(formatList.get(i).getOpen()) && charOfInput.contains(formatList.get(i).getClose())){
                        answersList.add("YES");
                    }
                    else {
                        answersList.add("NO");
                    }
                }
                else {

                }
            }
        }
        if (answersList.contains("NO")){
            System.out.println("NO");
        }
        else {
            System.out.println("YES");
        }
    }

}
final class formatModel{
    private char open,close;
    public formatModel() {
    }

    public formatModel(char open, char close) {
        this.open = open;
        this.close = close;
    }

    public char getOpen() {
        return open;
    }
    public void setOpen(char open) {
        this.open = open;
    }

    public char getClose() {
        return close;
    }

    public void setClose(char close) {
        this.close = close;
    }
}


