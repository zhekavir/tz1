public class StepTracker {
    MonthData[] monthToData;
    int purp = 10000;


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

        for (int i = 0; i < monthToData[monthStat - 1].days.length; i++) {
            System.out.println("вы прошли за " + (i + 1) + "." + (monthStat) + ".2022 " + monthToData[monthStat - 1].days[i] + " шагов");
        }
    }

    void changePurpose(int purps) {

        if (purps > 0) {
            purp = purps;
            System.out.println("ваша цель = " + purp);
        } else {
            System.out.println("количество шагов не может быть отрицательным");
        }
    }

    int sumStep(int monthStat) {
        int sumSteps = 0;
        for (int i = 0; i < monthToData[monthStat - 1].days.length; i++) {
            sumSteps += monthToData[monthStat - 1].days[i];
        }
        return sumSteps;
    }

    int maxStepDay(int monthStat) {
        int maxSteps = 0;
        for (int i = 0; i < monthToData[monthStat - 1].days.length; i++) {
            if (monthToData[monthStat - 1].days[i] > maxSteps) {
                maxSteps = monthToData[monthStat - 1].days[i];
            }
        }
        return maxSteps;
    }

    int averageStep(int monthStat) {
        return sumStep(monthStat) / monthToData[monthStat - 1].days.length;
    }

    int bestSeries(int monthStat) {
        int series = 0;
        int bestSeries = 0;
        for (int i = 0; i < monthToData[monthStat - 1].days.length; i++) {
                if (monthToData[monthStat - 1].days[i] >= purp) {
                    series +=1;
                    if (series > bestSeries) {
                        bestSeries = series;
                    }
                }else {
                series = 0;
            }
        }
        return bestSeries;
    }
}