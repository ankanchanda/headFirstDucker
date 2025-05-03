package ch2.somecode.displays;

import ch2.somecode.observer.Observer;
import ch2.somecode.subject.Subject;

public class StatisticDisplay implements Observer, DisplayElement {
    private Subject _weatherData;
    private float _maxTemperature;
    private float _minTemperature;
    private float _temperatureSum;
    private float _averageTemperature;
    private int _temperatureChangeCount;

    public StatisticDisplay(Subject weatherData) {
        this._weatherData = weatherData;
        this._weatherData.registerObserver(this);
        _temperatureChangeCount = 0;
        _maxTemperature = Float.MIN_VALUE;
        _minTemperature = Float.MAX_VALUE;
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " +
                _averageTemperature + "/" +
                _maxTemperature + "/" +
                _minTemperature);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        _temperatureChangeCount += 1;
        _temperatureSum += temperature;
        _maxTemperature = Math.max(_maxTemperature, temperature);
        _minTemperature = Math.min(_minTemperature, temperature);
        updateAverageTemperature();

        display();
    }

    private void updateAverageTemperature() {
        _averageTemperature = _temperatureSum / _temperatureChangeCount;
    }

}
