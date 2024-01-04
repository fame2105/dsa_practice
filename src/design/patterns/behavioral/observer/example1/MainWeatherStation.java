package design.patterns.behavioral.observer.example1;

public class MainWeatherStation {
    public static void main(String[] args) {
        // Create Observable
        WeatherData weatherData = new WeatherData();

        // Create Observers
        CurrentConditionsDisplay ccd = new CurrentConditionsDisplay(weatherData);
        ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);

        System.out.println("----------- Changing Weather Data ----------");

        weatherData.setMeasurements(82, 70, 29.2f);

        System.out.println("----------- Changing Weather Data ----------");
        weatherData.setMeasurements(78, 90, 29.2f);

    }
}
