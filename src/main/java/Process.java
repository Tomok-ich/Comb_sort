import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class Process {

    public static void run() throws Exception {
        File resultsDir = new File("results");
        if (!resultsDir.exists()) {
            resultsDir.mkdir();
        }

        BufferedWriter arrayWriter =
                new BufferedWriter(new FileWriter("results/results_array.csv"));

        BufferedWriter listWriter =
                new BufferedWriter(new FileWriter("results/results_collection.csv"));

        arrayWriter.write("Size,Time(Ms),Iterations\n");
        listWriter.write("Size,Time(Ms),Iterations\n");

        for (int size = 100; size <= 10000; size += 100) {
            for (int k = 0; k < 5; k++) {
                String filename = "data/data_" + size + "_" + k + ".txt";

                int[] arr = DataReader.readArray(filename);
                CombSort.Result r1 = CombSort.combSortArray(arr);

                arrayWriter.write(size + "," + r1.time + "," + r1.iterations + "\n");

                var list = DataReader.readList(filename);
                CombSort.Result r2 = CombSort.combSortList(list);

                listWriter.write(size + "," + r2.time + "," + r2.iterations + "\n");
            }
        }

        arrayWriter.close();
        listWriter.close();

        System.out.println("Результаты сохранены.");
    }
}
