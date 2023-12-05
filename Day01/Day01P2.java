import java.io.*;
import java.util.*;

public class Day01P2{
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("day01.dat"));
        int sum = 0;
        Map<String, String> digits = new HashMap<String, String>() {{
            put("one", "1");
            put("two", "2");
            put("three", "3");
            put("four", "4");
            put("five", "5");
            put("six", "6");
            put("seven", "7");
            put("eight", "8");
            put("nine", "9");
        }};

        while (in.hasNextLine()) {
            String line = in.nextLine();
            String number = "";
            String curr = "";
            outerloop:
            for (int i = 0; i < line.length(); i++) {
                if (line.substring(i, i + 1).matches("\\d")) {
                    number += line.substring(i, i + 1);
                    break;
                }
                else {
                    curr += line.substring(i, i + 1);
                    for (String digit : digits.keySet()) {
                        if (curr.contains(digit)) {
                            number += digits.get(digit);
                            break outerloop;
                        }
                    }
                }
            }

            curr = "";
            outerloop:
            for (int i = line.length() - 1; i >= 0; i--) {
                if (line.substring(i, i + 1).matches("\\d")) {
                    number += line.substring(i, i + 1);
                    break;
                }
                else {
                    curr = line.substring(i, i + 1) + curr;
                    for (String digit : digits.keySet()) {
                        if (curr.contains(digit)) {
                            number += digits.get(digit);
                            break outerloop;
                        }
                    }
                }
            }
            sum += Integer.parseInt(number);

        }
        System.out.println(sum);
    }
}