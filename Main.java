import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a phone number: ");
        String number = input.nextLine();
        PhoneNumber phone = new PhoneNumber(number);
        input.close();
    }
}