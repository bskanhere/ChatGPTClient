import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class FileReaderWriter {

    public static void main(String[] args) {

        // Define the file paths
        String inputFilePath = "input.txt";
        String outputFilePath = "output.txt";

        try {
            // Open the input file and create a BufferedReader
            File inputFile = new File(inputFilePath);
            //Arrays.stream(inputFile.listFiles()).map(File::getAbsolutePath).forEach(System.out::println);
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));

            // Open the output file and create a BufferedWriter
            File outputFile = new File(outputFilePath);
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            // Read from the input file and write to the output file
            String line;
            while ((line = reader.readLine()) != null) {
                writer.write(line);
                writer.newLine();
            }

            // Close the reader and writer
            reader.close();
            writer.close();

            System.out.println("File read and write completed successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
