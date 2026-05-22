import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Lets go andrew.");

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a phone number: ");
        long number = input.nextLong();
        PhoneNumber phone = new PhoneNumber(number);
        input.close();
    }
}