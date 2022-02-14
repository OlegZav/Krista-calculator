import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        System.out.println("Данное приложение выполняет математические действия с числами");
        while (true) {
            try {
                System.out.println("Хотите ли Вы продолжить работу с приложением?");
                System.out.print("1 - продолжить работу, 0 - завершить работу. Ваш выбор - ");
                Scanner firstScanner = new Scanner(System.in);
                int choice = firstScanner.nextInt();
                if (choice != 0) {
                    System.out.println("Введите через пробел математический пример. По окончании ввода нажмите Enter");
                    System.out.println("Пример ввода: 1 + 2 или 10 / 4 - 5 / 6");
                    System.out.println("Если необходимо произвести действие дроби с числом, то введите число так: number / 1, где number - Ваше число");
                    System.out.print("Ваш пример: ");
                    int result = 0;
                    String[] input;
                    if (args.length == 0) {
                        Scanner secondScanner = new Scanner(System.in);
                        input = secondScanner.nextLine().split(" ");
                    }
                    else {
                        input = args;
                        args = new String[0];
                    }
                    if (input.length == 3) {
                        int firstValue = Integer.parseInt(input[0]);
                        int secondValue = Integer.parseInt(input[2]);
                        String mathSign = input[1];
                        switch (mathSign) {
                            case "+":
                                result = firstValue + secondValue;
                                System.out.printf("Ваш результат равен %d\n", result);
                                break;
                            case "-":
                                result = firstValue - secondValue;
                                System.out.printf("Ваш результат равен %d\n", result);
                                break;
                            case "*":
                                result = firstValue * secondValue;
                                System.out.printf("Ваш результат равен %d\n", result);
                                break;
                            case "/":
                                result = firstValue / secondValue;
                                System.out.printf("Ваш результат равен %d\n", result);
                                break;
                            default:
                                System.out.println("Не обнаружен символ математической операции. Повторите ввод");
                                break;
                        }
                    } else if (input.length == 7) {
                        int firstNumerator = Integer.parseInt(input[0]);
                        int firstDenominator = Integer.parseInt(input[2]);
                        int secondNumerator = Integer.parseInt(input[4]);
                        int secondDenominator = Integer.parseInt(input[6]);
                        int denominator = 0;
                        int numerator = 0;
                        String mathSign = input[3];
                        switch (mathSign) {
                            case "+":
                                denominator = Math.nok(firstDenominator, secondDenominator);
                                numerator = firstNumerator * (denominator / firstDenominator) +
                                        secondNumerator * (denominator / secondDenominator);
                                System.out.printf("Ваш результат равен %d/%d\n", numerator, denominator);
                                break;
                            case "-":
                                denominator = Math.nok(firstDenominator, secondDenominator);
                                numerator = firstNumerator * (denominator / firstDenominator) -
                                        secondNumerator * (denominator / secondDenominator);
                                System.out.printf("Ваш результат равен %d/%d\n", numerator, denominator);
                                break;
                            case "*":
                                denominator = firstDenominator * secondDenominator;
                                numerator = firstNumerator * secondNumerator;
                                System.out.printf("Ваш результат равен %d/%d\n", numerator, denominator);
                                break;
                            case "/":
                                denominator = firstDenominator * secondNumerator;
                                numerator = firstNumerator * secondDenominator;
                                System.out.printf("Ваш результат равен %d/%d\n", numerator, denominator);
                                break;
                            default:
                                System.out.println("Не обнаружен символ математической операции. Повторите ввод");
                                break;
                        }
                    }


                }
                else {
                    System.out.println("Приложение завершило свою работу. Хорошего дня! (～￣▽￣)～");
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println("Было введено не целое число. Повторите ввод");
            } catch (InputMismatchException e) {
                System.out.println("Для ввода допускаются только 0 и 1. Повторите ввод");
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Было введено недостаточное количество элементов. Повторите ввод");
            } catch (ArithmeticException e) {
                System.out.println("Деление на 0. Повторите ввод");
            }
        }
    }
}

class Math {
    static int nok(int a, int b) {
        return a * b / nod(a, b);
    }

    static int nod(int a, int b) {
        if (b == 0) {
            return a;
        }
        return nod(b, a % b);
    }
}