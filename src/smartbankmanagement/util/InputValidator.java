package smartbankmanagement.util;

public class InputValidator {

    // Validate Mobile Number
    public static boolean isValidMobile(String mobile) {

        return mobile.matches("[0-9]{10}");
    }

    // Validate Email
    public static boolean isValidEmail(String email) {

        return email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }

    // Validate PIN
    public static boolean isValidPin(int pin) {

        return pin >= 1000 && pin <= 9999;
    }

    // Validate Amount
    public static boolean isValidAmount(double amount) {

        return amount > 0;
    }

}