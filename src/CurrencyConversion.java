import java.util.Scanner;
import java.util.ArrayList; // Import the ArrayList class

public class CurrencyConversion {
    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter an amount in $:");
        double dollarValue = input.nextDouble();
        double dollarValueTrunc = Math.floor(dollarValue * 100) / 100; 

        System.out.println("Choose currency to convert (Euro, Yen, BitCoin)");
        input = new Scanner(System.in);
        String currency = input.nextLine();

        ArrayList<String> supportedCurrency = new ArrayList<String>();
        supportedCurrency.add("euro");
        supportedCurrency.add("yen");
        supportedCurrency.add("bitcoin");
        boolean currencyCheck = false;

        while (currencyCheck == false) {
            for (String i:supportedCurrency) {
                // System.out.println(i.toLowerCase()); // DEBUG
                if (currency.toLowerCase().equals(i)) {
                    currencyCheck = true;
                    break;
                }
            }
            if (currencyCheck == false) {
                System.out.println("Invalid currency. Choose a supported currency (Euro, Yen, BitCoin)");
                input = new Scanner(System.in);
                currency = input.nextLine();
            }
        }

        System.out.printf("$%.2f", dollarValueTrunc);

        // Euro
        if (currency.toLowerCase().equals("euro")) {
            double euroValue = dollarValue * 0.86;
            double euroValueTrunc = Math.floor(euroValue * 100) / 100;
            System.out.printf(" can be converted into %.2f", euroValueTrunc);
            System.out.printf(" euros.");
        }

        // Yen
        if (currency.toLowerCase().equals("yen")) {
            double yenValue = dollarValue * 148.08;
            double yenValueTrunc = Math.floor(yenValue * 100) / 100;
            System.out.printf(" can be converted into %.2f", yenValueTrunc);
            System.out.printf(" yen.");
        }
        
        // Bitcoin
        if (currency.toLowerCase().equals("bitcoin")) {
            double bitcoinValue = dollarValue * 0.0000089;
            System.out.println(" can be converted into " + bitcoinValue + " bitcoin.");
        }
    }
}
