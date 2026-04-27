import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class DataGenerator {

    private static final String DATA_FOLDER = "data";

    public static void generateDataIfNeeded() throws IOException {
        File dir = new File(DATA_FOLDER);

        if (!dir.exists()) {
            dir.mkdir();
        }

        if (allRequiredFilesExist()) {
            System.out.println("Данные уже существуют, пропускаем генерацию.");
            return;
        }

        System.out.println("Генерируем данные...");

        Random rand = new Random();

        for (int size = 100; size <= 10000; size += 100) {
            for (int k = 0; k < 5; k++) {
                String filename = DATA_FOLDER + "/data_" + size + "_" + k + ".txt";
                File file = new File(filename);

                if (file.exists()) {
                    continue;
                }

                BufferedWriter writer = new BufferedWriter(new FileWriter(file));

                for (int i = 0; i < size; i++) {
                    writer.write(rand.nextInt(10000) + " ");
                }

                writer.close();
            }
        }

        System.out.println("Данные сгенерированы.");
    }

    private static boolean allRequiredFilesExist() {
        for (int size = 100; size <= 10000; size += 100) {
            for (int k = 0; k < 5; k++) {
                String filename = DATA_FOLDER + "/data_" + size + "_" + k + ".txt";
                if (!new File(filename).exists()) {
                    return false;
                }
            }
        }

        return true;
    }
}
