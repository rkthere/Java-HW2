import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.*;

public class Task3 {
    public static void main(String[] args) throws Exception {
        String [] arrayData = readLinesFromFile("dataforTask3.json");

        for(int i = 0; i < arrayData.length; i++) {
            OutputStreamWriter osw = new OutputStreamWriter(System.out, "UTF-8");
            osw.write(printLine(arrayData[i]).toString()+"\n");
            osw.flush();
        }
    }

    private static String[] readLinesFromFile(String fileName) throws Exception {
        Path path = Paths.get(fileName);
        return Files.readAllLines(path).toArray(new String[0]);
    }

    public static StringBuilder printLine(String line) {
        line = line.replace("{", "");
        line = line.replace("}", "");
        line = line.replaceAll("\"", "");
        line = line.replace("[", "");
        line = line.replace("]", "");
        StringBuilder result = new StringBuilder("");
        String [] arrayData = line.split(",");
        String [] listName = {"Студент ", " получил ", " по предмету "};
        for (int i =0; i < arrayData.length; i++) {
        String[] arrData = arrayData[i].split(":");
        result.append(listName[i]);
        result.append(arrData[1]);
        }
        return result;
    }
}