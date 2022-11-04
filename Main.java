import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker track = new StepTracker();
        Converter convert = new Converter();
        int userInput =0;
        do{
    printMenu();
    userInput = scanner.nextInt();
}
        while (userInput!=0); {


            if (userInput == 1) {
                System.out.println("Введите месяц от 1 до 12");
                int month = scanner.nextInt();
                if (month <= 12 && month > 0) {
                    System.out.println("Введите день от 1 до 30");
                } else {
                    System.out.println("Ошибка: введено некорректное значение");
                    return;
                }
                int days = scanner.nextInt();
                if (days <= 30 && days > 0) {
                    System.out.println("Введите шаги");
                } else {
                    System.out.println("Ошибка: введено некорректное значение");
                    return;
                }
                int steps = scanner.nextInt();
                if (steps >= 0) {
                    track.saveSteps(month, days, steps);
                    System.out.println("Записано");
                    track.printSteps(month, days);
                } else {
                    System.out.println("Ошибка: Введено отрицательное количество шагов");
                    return;
                }

            } else if (userInput == 2) {
                System.out.println("Напечатать статистику за определённый месяц");
                System.out.println("Введите месяц от 1 до 12");
                int monthStat = scanner.nextInt();
                if (monthStat <= 12 && monthStat > 0) {
                    track.statMonth(monthStat);
                    System.out.println("Максимально за день вы прошли " + track.maxStepDay(monthStat) + " шагов");
                    System.out.println("Всего за месяц вы прошли " + track.sumStep(monthStat) + " шагов");
                    System.out.println("В среднем за месяц вы проходили " + track.averageStep(monthStat));
                    double maxStep = track.sumStep(monthStat);
                    int stepCcal = track.sumStep(monthStat);
                    System.out.println("За месяц вы прошли " + convert.stepInKm(maxStep) + " километров");
                    System.out.println("За месяц вы сожгли " + convert.ccal(stepCcal) + " килокалорий");
                    System.out.println("Ваша лучшая серия " + track.bestSeries(monthStat));
                } else {
                    System.out.println("Ошибка: Месяц введен некорректно");
                }

            } else if (userInput == 3) {
                System.out.println("Введите цель по количеству шагов в день");
                int purps = scanner.nextInt();
                track.changePurpose(purps);
            } else if (userInput == 4) {
                System.out.println("Выход");
                return;
            } else {
                System.out.println("Извините, такой команды пока нет.");
            }
        }
    }

    private static void printMenu() {
        System.out.println("1. Ввести количество шагов за определённый день");
        System.out.println("2. Напечатать статистику за определённый месяц");
        System.out.println("3. Изменить цель по количеству шагов в день");
        System.out.println("4. Для выхода из приложения введите 0");
    }
}