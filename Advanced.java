import java.util.ArrayList;
import java.util.Scanner;

public class Advanced {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int openPosition=0, closePosition = 0;
        int timesOfOpen = 0, timesOfClose = 0;
        System.out.print("Enter a string: ");
        String inputString = input.nextLine();
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

        if (inputString.trim().length()==1){
            answersList.add("YES");
        }

        else if (charOfInput.size()==0){
            answersList.add("YES");
        }

        else {
            for (int i=0; i<formatList.size(); i++){
                if (charOfInput.contains(formatList.get(i).getOpen())){
                    if (charOfInput.contains(formatList.get(i).getOpen()) && charOfInput.contains(formatList.get(i).getClose())){

                        //check times of open and close
                        
                        for (int j=0; j<charOfInput.size(); j++){
                            for (int k=0; k<formatList.size(); k++){
                                if (charOfInput.get(j)==formatList.get(k).getOpen()){
                                    timesOfOpen++;
                                }
                                else if (charOfInput.get(j)==formatList.get(k).getClose()){
                                    timesOfClose++;
                                }
                            }
                        }
                        if (timesOfClose==timesOfOpen){
                            answersList.add("YES");
                        }
                        else {
                            answersList.add("NO");
                        }
                        for (int j = 0; j < charOfInput.size(); j++) {
                            for (int k = 0; k < formatList.size(); k++) {
                                if (charOfInput.get(j) == formatList.get(k).getOpen()) {
                                    openPosition = j;
                                    if (charOfInput.contains(formatList.get(k).getClose())) {
                                        answersList.add("YES");
                                    }
                                    else {
                                        answersList.add("NO");
                                    }

                                    for (int l = 0; l < charOfInput.size(); l++) {
                                        if (formatList.get(k).getClose() == charOfInput.get(l)) {
                                            closePosition = l;
                                        }
                                    }

                                    if (closePosition > openPosition) {
                                        answersList.add("YES");
                                    }
                                    else {
                                        answersList.add("NO");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (answersList.contains("NO")){
            System.out.println("NO");
        }
        else if (answersList.size()==0){
            System.out.println("NO");
        }
        else{
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


