import java.io.*;
import java.util.*;

public class Day02 {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(new File("day02.dat"));
        int sum = 0;

        while (in.hasNextLine()) {
            String[] line = in.nextLine().split("[:;]");
            int id = Integer.parseInt(line[0].substring(line[0].indexOf(" ") + 1));
            Map<String, Integer> colors = new HashMap<String, Integer>();
            colors.put("red", 0);
            colors.put("green", 0);
            colors.put("blue", 0);
            for (int i = 1; i < line.length; i++) {
                String[] cubes = line[i].split(",");
                for (String cube : cubes) {
                    try (Scanner reader = new Scanner(cube)) {
                        int num = reader.nextInt();
                        String color = reader.next();
                        if (num > colors.get(color)) {
                            colors.put(color, num);
                        }
                    }
                }
            }
            if (colors.get("red") <= 12 && colors.get("green") <= 13 && colors.get("blue") <= 14) {
                sum += id;
            }

        }
        System.out.println(sum);
    }
}