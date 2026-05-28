import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Fun Fact: Phone words generate 2X as many calls as regular phone numbers. I don't know where to put the research so its going here.
        Scanner input = new Scanner(System.in);
        System.out.println("");
        System.out.print("Enter a phone number: ");
        /* if (input.hasNextLine()) {
            String number = input.nextLine();
            System.out.println("\n\n");
            PhoneNumber phone = new PhoneNumber(number);
        } else {
            System.out.println("\nError: No input detected from the console environment!");
        } */
        String number = input.nextLine();
        //System.out.print(Words.getWords());
        //System.out.println(Words.getWords().size());
        System.out.println("\n\n");
        PhoneNumber phone = new PhoneNumber(number); 
        input.close();
    }
}