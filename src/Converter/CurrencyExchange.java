package Converter;

public class CurrencyExchange {
    private static final double[] RUB_TO_CURRENCY = {
            0.01,   // USD
            0.009,  // EUR
            0.034,  // BYN
            1.0,    // RUB
            5.03,  // KZT
    };

    public double getToRubleCurrency(Currency from) {
        return RUB_TO_CURRENCY[from.ordinal()];
    }

    public double getFromRubleCurrency(Currency to) {
        return RUB_TO_CURRENCY[to.ordinal()];
    }
}
