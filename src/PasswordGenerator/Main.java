package PasswordGenerator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Generator generator = new Generator();
        int length;

        System.out.print("Введите длину пароля (от 8 до 12): ");
        length = Integer.parseInt(scanner.nextLine());
        if (length < 8) length = 8;
        if (length > 12) length = 12;

        String password = generator.generatePassword(length);
        System.out.print("\nСгенерированный пароль: " + password);

        scanner.close();
    }
}
