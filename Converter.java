
public class Converter {

    double stepInKm(double maxStep) {
        return maxStep * 0.00075;
    }

    int ccal(int maxStep) {
        return (maxStep * 50) / 1000;
    }
}

