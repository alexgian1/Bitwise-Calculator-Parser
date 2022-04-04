import java.text.ParseException;
import java.text.StringCharacterIterator;
import java.text.CharacterIterator;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Parser {
    static String input;
    static CharacterIterator it;
    static List<Character> nums = Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9');

    public static void main(String[] args) throws ParseException {
        System.out.println("Input: ");
        try (Scanner scanner = new Scanner(System.in)) {
            input = scanner.nextLine();
        }
        it = new StringCharacterIterator(input);
        exp();
        end();
        System.out.println("Out: " + input);
        System.out.println("Parse successful");
    }

    static void exp() throws ParseException {
        if (nums.contains(it.current()) || it.current() == '(') {
            term();
            exp2();
        } else
            throw new ParseException("Syntax error", 0);
    }

    static void exp2() throws ParseException {
        if (it.current() == '^') {
            match('^');
            term();
            exp2();
        }
    }

    static void term() throws ParseException {
        if (nums.contains(it.current()) || it.current() == '(') {
            exp3();
            term2();
        } else
            throw new ParseException("Syntax error", 0);
    }

    static void term2() throws ParseException {
        if (it.current() == '&') {
            match('&');
            exp3();
            term2();
        }
    }

    static void exp3() throws ParseException {
        if (it.current() == '(') {
            match('(');
            exp();
            match(')');
        } else if (nums.contains(it.current()))
            num();
        else
            throw new ParseException("Syntax error", 0);
    }

    static void num() throws ParseException {
        if (it.current() == '0')
            match('0');
        else if (it.current() == '1')
            match('1');
        else if (it.current() == '2')
            match('2');
        else if (it.current() == '3')
            match('3');
        else if (it.current() == '4')
            match('4');
        else if (it.current() == '5')
            match('5');
        else if (it.current() == '6')
            match('6');
        else if (it.current() == '7')
            match('7');
        else if (it.current() == '8')
            match('8');
        else if (it.current() == '9')
            match('9');
        else
            throw new ParseException("Syntax error", 0);
    }

    static void end() throws ParseException {
        if (it.current() == CharacterIterator.DONE
            || it.current() == '\n')
            return;
        else
            throw new ParseException("Syntax error", 0);
    }

    static void match(char c) throws ParseException {
        if (it.current() == c || it.current() != CharacterIterator.DONE) {
            it.next();
        } else {
            throw new ParseException("Syntax error", 0);
        }
    }

}