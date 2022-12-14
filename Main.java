import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker track = new StepTracker();

        int userInput;
        do {
            printMenu();
            userInput = scanner.nextInt();

            if (userInput == 1) {
                System.out.println("Введите месяц от 1 до 12");
                int month = scanner.nextInt();

                if (month <0 || month >12) {
                    System.out.println("Ошибка: введено некорректное значение");
                    continue;
                }
                System.out.println("Введите день от 1 до 30");
                int days = scanner.nextInt();

                if (days > 30 || days < 0) {
                    System.out.println("Ошибка: введено некорректное значение");
                    continue;
                }

                System.out.println("Введите шаги");
                int steps = scanner.nextInt();
                if (steps < 0) {
                    System.out.println("Ошибка: Введено отрицательное количество шагов");
                    continue;
                }
                track.saveSteps(month, days, steps);
                System.out.println("Записано");
                track.printSteps(month, days);

            } else if (userInput == 2) {
                System.out.println("Напечатать статистику за определённый месяц");
                System.out.println("Введите месяц от 1 до 12");
                int monthStat = scanner.nextInt();
                if (monthStat <= 12 && monthStat > 0) {
                    track.statMonth(monthStat);

                } else {
                    System.out.println("Ошибка: Месяц введен некорректно");
                }

            } else if (userInput == 3) {
                System.out.println("Введите цель по количеству шагов в день");
                int purps = scanner.nextInt();
                track.changePurpose(purps);
            } else if (userInput == 4) {
                System.out.println("Выход");
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
        while (userInput != 4);
    }

    private static void printMenu() {
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("4. Для выхода из приложения введите 0");
    }
}