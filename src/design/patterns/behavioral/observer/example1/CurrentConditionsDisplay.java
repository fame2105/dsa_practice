package design.patterns.behavioral.observer.example1;

public class CurrentConditionsDisplay implements Observer, Display {
    Observable weatherStation;
    private float temperature;
    private float humidity;
    private float pressure;

    public CurrentConditionsDisplay(Observable weatherStation) {
        this.weatherStation = weatherStation;
        this.weatherStation.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println(toString());
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public String toString() {
        return "CurrentConditionsDisplay{" +
                "temperature=" + temperature +
                ", humidity=" + humidity +
                ", pressure=" + pressure +
                '}';
    }
}
