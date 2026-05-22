import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a phone number (we recommend excluding the country code): ");
        String number = input.nextLine();
        PhoneNumber phone = new PhoneNumber(number);
        input.close();
    }
}