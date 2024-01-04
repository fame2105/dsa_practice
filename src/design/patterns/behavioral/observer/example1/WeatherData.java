package design.patterns.behavioral.observer.example1;

import java.util.ArrayList;
import java.util.List;

public class WeatherData implements Observable{
    private List<Observer> observers;

    private float temperature;
    private float humidity;
    private float pressure;

    public WeatherData() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void unRegisterObserver(Observer o) {
            int idx = this.observers.indexOf(o);
            if(idx != -1) {
                this.observers.remove(idx);
            }
    }

    @Override
    public void notifyObservers() {
        for(Observer o : observers) {
            o.update(this.temperature, this.humidity, this.pressure);
        }
    }

    // as soon as measurements get updated we want to notify all the registered observers
    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        notifyObservers();
    }

    public float getTemperature() {
        return this.temperature;
    }

    public float getHumidity() {
        return this.humidity;
    }

    public float getPressure() {
        return this.pressure;
    }
}
