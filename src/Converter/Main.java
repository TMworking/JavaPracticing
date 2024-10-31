package Converter;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CurrencyExchange exchanger = new CurrencyExchange();
        Converter converter = new Converter(exchanger);
        double amount;
        Currency fromCurrency;

        System.out.println("Валюты для обмена: ");
        for (Currency currency : Currency.values()) {
            System.out.println("- " + currency);
        }

        System.out.print("\nВведите исходную валюту: ");
        String fromCurrencyInput = scanner.nextLine().toUpperCase();

        try {
            fromCurrency = Currency.valueOf(fromCurrencyInput);
        } catch (IllegalArgumentException e) {
            System.out.println("Введите корректную валюту");
            scanner.close();
            return;
        }

        System.out.print("Введите количество валюты: ");
        try {
            amount = Double.parseDouble(scanner.nextLine());
            if (amount < 0) {
                System.out.println("Количетсво должно быть неотрицательно");
                scanner.close();
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Введите корректное число");
            scanner.close();
            return;
        }

        System.out.println("\n" + amount + " " + fromCurrency + " = ");
        converter.convert(fromCurrency, amount);
        scanner.close();
    }
}
