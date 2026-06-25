public class ForecastTest {
    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05; // 5%
        int periods = 10;
        
        double futureValue = Forecast.calculateFutureValue(presentValue, growthRate, periods);
        System.out.printf("Future Value after %d periods: $%.2f\n", periods, futureValue);
    }
}