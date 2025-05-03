package ch2.somecode.subject;

import java.util.ArrayList;
import java.util.List;

import ch2.somecode.observer.Observer;

public class WeatherData implements Subject{

    private List<Observer> _observersList;
    private float _temparature;
    private float _humidity;
    private float _pressure;

    public WeatherData() {
        _observersList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        _observersList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = _observersList.indexOf(observer);
        if(index >= 0) _observersList.remove(index);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : _observersList) {
            observer.update(_temparature, _humidity, _pressure);
        }
    }
    
    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temparature, float humidity, float pressure) {
        this._temparature = temparature;
        this._humidity = humidity;
        this._pressure = pressure;

        measurementsChanged();
    }
}
