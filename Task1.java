import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task1 {
    public static void main(String[] args) throws IOException {
      String[] list = readLinesFromFile("dataForSelect.txt");
      System.out.println(list[0]);
      StringBuilder resultSelect = lineInList(list[0]);
      System.out.println(resultSelect);
    }

    public static String[] readLinesFromFile(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try {
            String[] lines = br.lines().toArray(String[]::new);
            return lines;
        } finally {
            br.close();
        }
    }

    public static StringBuilder lineInList(String line) {
        String line1 = line.replace("{", "");
        String line2 = line1.replace("}", "");
        String line3 = line2.replaceAll("\"", "");
        System.out.println(line3);
        StringBuilder result = new StringBuilder("select * from students where ");

        String[] arrayData = line3.split(", ");
        for (int i = 0; i < arrayData.length; i++) {
            String[] arrData = arrayData[i].split(":");
            if (!arrData[1].equals("null")) {
                if (i != 0) {
                    result.append(", ");
                    result.append(arrData[0]);
                    result.append(" = ");
                    result.append(arrData[1]);
                } else {
                    result.append(arrData[0]);
                    result.append(" = ");
                    result.append(arrData[1]);
                }
            }
        }
        return result;
    }
}