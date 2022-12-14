public class StepTracker {
    MonthData[] monthToData;
    int purp = 10000;
    Converter convert = new Converter();


    public StepTracker() {

        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }

    }

    class MonthData {
        int[] days;

        MonthData() {
            days = new int[30];
        }
    }

    void printSteps(int monthStat, int day) {
        System.out.println("вы прошли за день = " + monthToData[monthStat - 1].days[day - 1]);
    }

    void saveSteps(int monthStat, int day, int steps) {
        monthToData[monthStat - 1].days[day - 1] = steps;

    }

    void statMonth(int monthStat) {
        int[] days = monthToData[monthStat - 1].days;
        int sumSteps = 0;
        int maxSteps = 0;
        int series = 0;
        int bestSeries = 0;
        for (int i = 0; i < days.length; i++) {
            int daySteps = days[i];
            System.out.println("вы прошли за " + (i + 1) + "." + (monthStat) + ".2022 " + daySteps + " шагов");

            sumSteps += daySteps;
            if (daySteps > maxSteps) {
                maxSteps = daySteps;
            }
            if (daySteps >= purp) {
                series += 1;
                if (series > bestSeries) {
                    bestSeries = series;
                }
            } else {
                series = 0;
            }
        }
        System.out.println("Максимально за день вы прошли " + maxSteps + " шагов");
        System.out.println("Всего за месяц вы прошли " + sumSteps + " шагов");
        int averageStep = sumSteps / days.length;
        System.out.println("В среднем за месяц вы проходили " + averageStep);
        System.out.println("За месяц вы прошли " + convert.stepInKm(maxSteps) + " километров");
        System.out.println("За месяц вы сожгли " + convert.ccal(maxSteps) + " килокалорий");
        System.out.println("Ваша лучшая серия " + bestSeries);
    }


    void changePurpose(int purps) {

        if (purps > 0) {
            purp = purps;
            System.out.println("ваша цель = " + purp);
        } else {
            System.out.println("количество шагов не может быть отрицательным");
        }
    }
}