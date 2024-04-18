import java.util.Arrays;
import java.util.Scanner;

public class LexicalAnalyzer{
    public static boolean isAlphabet(char c) {
        return ((c >='a' && c <= 'z') || (c >='A' && c <= 'Z'));
    }
    public static boolean isNumber(char c) {
        return (c >= '0' && c <= '9') || c == '.';
    }
    public static void main (String[] args) {
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter input:");
        String userName = myObj.nextLine();
        String str = userName;
        String[] keywords = {"int", "float", "const", "return"};
        Character[] operators = {'+', '-', '*', '/', '='};

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == ' ') {
                continue;
            } else if (isAlphabet(c)) {
                StringBuilder strBuild = new StringBuilder();
                while(i < str.length() && (isAlphabet(str.charAt(i)))) {
                    strBuild.append(str.charAt(i));
                    i++;
                }
                String token = strBuild.toString();
                if (Arrays.asList(keywords).contains(token)) {
                    System.out.println(token +" is a keyword");
                } else {
                    System.out.println(token +" is a variable");
                }
                if (str.charAt(i) == ';') {
                    System.out.println(str.charAt(i)+ " is a separator");
                }
                i--;
            } else if (isNumber(c)) {
                StringBuilder strBuild = new StringBuilder();
                while(i < str.length() && (isNumber(str.charAt(i)))) {
                    strBuild.append(str.charAt(i));
                    i++;
                }
                System.out.println(strBuild +" is a constant");
                if (str.charAt(i) == ';') {
                    System.out.println(str.charAt(i)+ " is a separator");
                }
                i--;
            } else if (Arrays.asList(operators).contains(c)) {
                if (c == '=') {
                    System.out.println(c + " is an assignment operator");
                } else {
                    System.out.println(c + " is an operator");
                }
            }
        }
    }
}
