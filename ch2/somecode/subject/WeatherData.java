package ch2.somecode.subject;

import java.util.ArrayList;
import java.util.List;

import ch2.somecode.observer.Observer;

public class WeatherData implements Subject{

    private List<Observer> observers;
    private float temparature;
    private float humidity;
    private float pressure;

    WeatherData() {
        observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observers.indexOf(observer);
        if(index >= 0) observers.remove(index);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temparature, humidity, pressure);
        }
    }
    
    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temparature, float humidity, float pressure) {
        this.temparature = temparature;
        this.humidity = humidity;
        this.pressure = pressure;

        measurementsChanged();
    }
}
