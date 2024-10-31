package Converter;

public class Converter {
    private final CurrencyExchange exchanger;

    public Converter(CurrencyExchange exchanger) {
        this.exchanger = exchanger;
    }

    public void convert(Currency fromCurrency, double amount) {
        double amountInRub = amount / exchanger.getToRubleCurrency(fromCurrency);

        for (Currency toCurrency : Currency.values()) {
            if (toCurrency != fromCurrency) {
                double convertedAmount = amountInRub * exchanger.getFromRubleCurrency(toCurrency);
                System.out.printf("%.2f %s%n", convertedAmount, toCurrency);
            }
        }
    }
}