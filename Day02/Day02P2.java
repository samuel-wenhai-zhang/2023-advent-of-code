import java.io.*;
import java.util.*;

public class Day02P2 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("day02.dat"));
        int sum = 0;

        while (in.hasNextLine()) {
            String[] line = in.nextLine().split("[:;]");
            Map<String, Integer> colors = new HashMap<String, Integer>();
            for (int i = 1; i < line.length; i++) {
                String[] cubes = line[i].split(",");
                for (String cube : cubes) {
                    try (Scanner reader = new Scanner(cube)) {
                        int num = reader.nextInt();
                        String color = reader.next();
                        if (!colors.containsKey(color)) {
                            colors.put(color, num);
                        }
                        if (num > colors.get(color)) {
                            colors.put(color, num);
                        }
                    }
                }
            }
            int product = 1; // what if there's 0 cubes
            if (colors.containsKey("red")) {
                product *= colors.get("red");
            }
            if (colors.containsKey("green")) {
                product *= colors.get("green");
            }
            if (colors.containsKey("blue")) {
                product *= colors.get("blue");
            }
            sum += product;

        }
        System.out.println(sum);
    }
}