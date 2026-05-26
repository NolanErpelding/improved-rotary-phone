import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Words { 
    public static void main(String[] args) {
        File sentimentValues = new File("SentimentValues.txt");

        // The try-with-resources block automatically handles closing the reader
        try (Scanner reader = new Scanner(sentimentValues)) {
            
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                // You can now use the 'data' variable here
                System.out.println(data); 
            }
            
        } catch (FileNotFoundException e) {
            System.out.println("Error: The file 'SentimentValues.txt' could not be found.");
            e.printStackTrace();
        }
    }
    
    /* File sentimentValues = new File("SentimentValues.txt");
     Scanner reader = new Scanner(sentimentValues);

     while(reader.hasNextLine()){
        String data = reader.nextLine();
     }

     reader.close(); */

}
