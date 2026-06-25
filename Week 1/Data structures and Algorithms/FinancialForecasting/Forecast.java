public class Forecast {
    // FV = PV * (1 + rate)^periods (Recursive approach)
    public static double calculateFutureValue(double pv, double rate, int periods) {
        if (periods == 0) {
            return pv;
        }
        return calculateFutureValue(pv * (1 + rate), rate, periods - 1);
    }
}