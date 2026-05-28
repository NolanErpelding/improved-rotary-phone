import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Fun Fact: Phone words generate 2X as many calls as regular phone numbers. I don't know where to put the research so its going here.
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a phone number: ");
        String number = input.nextLine();
        //System.out.print(Words.getWords());
        //System.out.println(Words.getWords().size());
        PhoneNumber phone = new PhoneNumber(number);
        input.close();
    }
}