import java.text.ParseException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Parser {
    static String input;
    static char l;
    static int index = 0;
    static List<Character> nums = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    public static void main(String[] args) throws ParseException {
        System.out.println("Input: ");
        try (Scanner scanner = new Scanner(System.in)) {
            input = scanner.nextLine();
        }
        l = input.charAt(index);
        exp();
        end();
        System.out.println("Out: " + input);
    }

    static void exp() throws ParseException {
        if (nums.contains(l) || l == '(') {
            term();
            exp2();
        } else
            throw new ParseException("Syntax error", 0);
    }

    static void exp2() throws ParseException {
        if (l == '^') {
            match('^');
            term();
            exp2();
        }
    }

    static void term() throws ParseException {
        if (nums.contains(l) || l == '(') {
            exp3();
            term2();
        } else
            throw new ParseException("Syntax error", 0);
    }

    static void term2() throws ParseException {
        if (l == '&') {
            match('&');
            exp3();
            term2();
        }
    }

    static void exp3() throws ParseException {
        if (l == '(') {
            match('(');
            exp();
            match(')');
        } else if (nums.contains(l))
            num();
        else
            throw new ParseException("Syntax error", 0);
    }

    static void num() throws ParseException {
        if (l == '0')
            match('0');
        else if (l == '1')
            match('1');
        else if (l == '2')
            match('2');
        else if (l == '3')
            match('3');
        else if (l == '4')
            match('4');
        else if (l == '5')
            match('5');
        else if (l == '6')
            match('6');
        else if (l == '7')
            match('7');
        else if (l == '8')
            match('8');
        else if (l == '9')
            match('9');
        else
            throw new ParseException("Syntax error", 0);

    }

    static void end() throws ParseException {
        if (l == '\n')
            match('\n');
        else if (l == '$')
            match('$');
        else
            throw new ParseException("Syntax error", 0);
    }

    static void match(char c) throws ParseException {
        if (l == c) {
            index++;
            if (index <= input.length() - 1)
                l = input.charAt(index);
            else if (index == input.length())
                ;// Last character
            else
                throw new ParseException("Syntax error", 0);
        } else {
            throw new ParseException("Syntax error", 0);
        }
    }

}