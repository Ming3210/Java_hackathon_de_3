package ra.validate;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validator {
    public static int isInputInt(Scanner scanner, String message, int minValue) {
        System.out.println(message);
        do {
            if (!scanner.hasNextInt()) {
                System.err.println("Dữ liêu ko phải số nguyên, vui lòng nhập lại");
                scanner.nextLine();
                continue;
            }
            int number = Integer.parseInt(scanner.nextLine());
            if (number > minValue) {
                return number;
            }
            System.out.printf("Giá trị phải lớn hơn %d, vui lòng nhập lại\n", minValue);
        } while (true);
    }

    public static int isInputByte(Scanner scanner, String message) {
        System.out.println(message);
        do {
            if (!scanner.hasNextByte()) {
                System.err.println("Dữ liêu ko phải byte, vui lòng nhập lại");
                scanner.nextLine();
                continue;
            }
            byte number = Byte.parseByte(scanner.nextLine());


        } while (true);
    }

    public static String isInputString(Scanner scanner, String message) {
        System.out.println(message);
        while (!scanner.hasNextLine()) {
            System.err.println("Dữ liệu ko phải là chuỗi, vui lòng nhập lại");
            scanner.nextLine();
        }
        return scanner.nextLine();
    }

    public static float isInputFloat(Scanner scanner, String message, float minValue) {
        System.out.println(message);
        do {
            if (!scanner.hasNextFloat()) {
                System.err.println("Dữ liệu ko hợp lệ");
                scanner.nextLine();
                continue;
            }
            float number = Float.parseFloat(scanner.nextLine());
            if (number > minValue) {
                return number;
            }
            System.out.printf("Giá trị phải lớn hơn %f, vui lòng nhập lại\n", minValue);
        } while (true);
    }

    public static boolean isInputBoolean(Scanner scanner, String message) {
        System.out.println(message);
        do {
            String inputString = scanner.nextLine();
            if (inputString.equalsIgnoreCase("true") || inputString.equalsIgnoreCase("false")) {
                return Boolean.parseBoolean(inputString);
            }
            System.err.println("Kiểu dữ liệu ko hợp lệ");
        } while (true);
    }

    public static String validatePattern(Scanner scanner, String message, String regex) {
        System.out.printf(message);

        do {
            String inputString = scanner.nextLine();
            if (Pattern.matches(regex, inputString)) {
                return inputString;
            }
            System.err.println("Dữ liệu ko hợp lệ");
        } while (true);
    }
}
