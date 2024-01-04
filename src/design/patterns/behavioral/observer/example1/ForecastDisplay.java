package design.patterns.behavioral.observer.example1;

public class ForecastDisplay implements Observer,Display{
    private float currentPressure = 29.92f;
    private float lastPressure;
    private Observable weatherData;

    public ForecastDisplay(Observable weatherData) {
        this.weatherData = (WeatherData) weatherData;
        this.weatherData.registerObserver(this);
    }


    @Override
    public void display() {
        System.out.print("Forecast: ");
        if (currentPressure > lastPressure) {
            System.out.println("Improving weather on the way!");
        } else if (currentPressure == lastPressure) {
            System.out.println("More of the same");
        } else if (currentPressure < lastPressure) {
            System.out.println("Watch out for cooler, rainy weather");
        }
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.lastPressure = currentPressure;
        this.currentPressure = pressure;
        display();
    }
}
