package ch2.someCode.subject;

import java.util.ArrayList;
import java.util.List;

import ch2.someCode.observer.Observer;

public class WeatherData implements Subject{

    private List<Observer> _observersList;
    private float _temperature;
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
            // observer.update(_temperature, _humidity, _pressure);
            observer.update();
        }
    }
    
    private void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this._temperature = temperature;
        this._humidity = humidity;
        this._pressure = pressure;

        measurementsChanged();
    }

    public float getTemperature() {
        return this._temperature;
    }

    public float getHumidity() {
        return this._humidity;
    }

    public float getPressure() {
        return this._pressure;
    }
}
