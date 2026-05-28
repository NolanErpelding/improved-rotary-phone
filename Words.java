import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Words {
    
    private static ArrayList<String> words;
    private static ArrayList<Double> sentiment;    
    private static File sentimentValues = new File("SentimentValues.txt");

    // This is a static block its kinda like an initializer for static stuff
    //I wrote this not AI alright VEDANT!
    static {
        words = new ArrayList<>();
        sentiment = new ArrayList<>();
        try (Scanner reader = new Scanner(sentimentValues)) {

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                words.add(data.substring(0, data.indexOf(",")));
                sentiment.add(Double.parseDouble(data.substring(data.indexOf(",") + 1)));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error: The file 'SentimentValues.txt' could not be found.");
            e.printStackTrace();
        }
    }
    
    public static ArrayList<String> getWords() {
        return words;
    }

    public static ArrayList<Double> getSentiment() {
        return sentiment;
    }
    public static boolean isWord(String word) {
        return words.contains(word);
    }
}
