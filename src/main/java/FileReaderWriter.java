import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReaderWriter {

    public static void main(String[] args) {

        // Define the file paths
        String inputFolderPath = "input/";
        String outputFolderPath = "output/";

        try {
            // Open the input file and create a BufferedReader
            File inputFolder = new File(inputFolderPath);
            List<String> files = Arrays.stream(inputFolder.listFiles()).map(File::getName).collect(Collectors.toList());
            for (String inputFile : files) {
                BufferedReader reader = new BufferedReader(new FileReader(inputFolderPath + inputFile));

                // Open the output file and create a BufferedWriter
                File outputFile = new File(outputFolderPath + inputFile);
                BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

                // Read from the input file and write to the output file
                String line;
                StringBuilder question = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    question.append(line).append("\n");
                }
                writer.write(ChatGPTClient.getChatGPTResponse(question.toString()));
                // Close the reader and writer
                reader.close();
                writer.close();
            }

            System.out.println("Files read and write completed successfully.");

        } catch(IOException e){
            e.printStackTrace();
        }
    }
}
