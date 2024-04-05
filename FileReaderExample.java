import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileReaderExample {
    public static String[][] readFile(String fileName) {
        List<String[]> dataList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.trim().split("\\s+");
                dataList.add(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataList.toArray(new String[0][]);
    }

    public static void main(String[] args) {
        String[][] dataArray = readFile("file.txt");

        for (String[] data : dataArray) {
            System.out.println(Arrays.toString(data));
        }
    }
}



