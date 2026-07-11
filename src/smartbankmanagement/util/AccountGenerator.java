package smartbankmanagement.util;

public class AccountGenerator {

    private static int accountCounter = 1001;

    public static String generateAccountNumber() {
        return "SB" + accountCounter++;
    }

}