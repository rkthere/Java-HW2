import java.io.FileWriter;
import java.io.IOException;

public class Task2 {
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            logArray(arr, i + 1);
        }
    }

    private static void logArray(int[] arr, int iteration) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write("Iteration " + iteration + ": ");
            for (int i = 0; i < arr.length; i++) {
                writer.write(arr[i] + " ");
            }
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("An error occurred while logging the array.");
        }
    }

    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        sort(arr);
    }
}
