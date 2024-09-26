import java.util.HashMap;
import java.util.*;

public class CurrencyConverter {
    private static HashMap<String, Double> exchangeRates = new HashMap<>();

    public static void main(String[] args) {
        exchangeRates.put("INR", 1.0);
        exchangeRates.put("USD", 0.0119);
        exchangeRates.put("EUR", 0.0107);
        exchangeRates.put("GBP", 0.009);
        exchangeRates.put("JPY", 1.6732);

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the base currency among these (INR, USD, EUR, GBP, JPY): ");
        String baseCurrency = sc.nextLine().toUpperCase();
        System.out.println("Enter the target currency among these(INR, USD, EUR, GBP, JPY): ");
        String targetCurrency = sc.nextLine().toUpperCase();
        System.out.println("Enter the amount you want to convert: ");
        double amount = sc.nextDouble();
        double convertedAmount = convertCurrency(baseCurrency, targetCurrency, amount);
        if (convertedAmount != -1) {
            System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
        } else {
            System.out.println("Conversion failed. Please check the currency codes.");
        }
        sc.close();
    }

    public static double convertCurrency(String baseCurrency, String targetCurrency, double amount) {
        if (exchangeRates.containsKey(baseCurrency) && exchangeRates.containsKey(targetCurrency)) {
            double baseRate = exchangeRates.get(baseCurrency);
            double targetRate = exchangeRates.get(targetCurrency);
            double amountInINR = amount / baseRate;
            return amountInINR * targetRate;
        } else {
            return -1;
        }
    }
}