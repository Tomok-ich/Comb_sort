import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataReader {

    public static int[] readArray(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        reader.close();

        String[] parts = line.trim().split(" ");
        int[] arr = new int[parts.length];

        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i]);
        }

        return arr;
    }

    public static ArrayList<Integer> readList(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line = reader.readLine();
        reader.close();

        String[] parts = line.trim().split(" ");
        ArrayList<Integer> list = new ArrayList<>();

        for (String p : parts) {
            list.add(Integer.parseInt(p));
        }

        return list;
    }
}
