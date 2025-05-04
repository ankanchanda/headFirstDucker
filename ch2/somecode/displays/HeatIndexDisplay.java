package ch2.somecode.displays;

import ch2.somecode.observer.Observer;
import ch2.somecode.subject.WeatherData;

public class HeatIndexDisplay implements Observer, DisplayElement {

    private WeatherData _weatherData;
    private float _temperature;
    private float _humidity;
    private float _heatIndex;

    public HeatIndexDisplay(WeatherData weatherData) {
        this._weatherData = weatherData;
        this._weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Heat Index: " + _heatIndex);
    }

    // @Override
    // public void update(float temperature, float humidity, float pressure) {
    //     this._temperature = temperature;
    //     this._humidity = humidity;

    //     updateHeatIndex();
    //     display();
    // }

    @Override
    public void update() {
        this._temperature = this._weatherData.getTemperature();
        this._humidity = this._weatherData.getHumidity();

        updateHeatIndex();
        display();
    }

    private void updateHeatIndex() {
        _heatIndex = (float) ((16.923 + (0.185212 * _temperature) +
                (5.37941 * _humidity) - (0.100254 * _temperature * _humidity) +
                (0.00941695 * (_temperature * _temperature)) +
                (0.00728898 * (_humidity * _humidity)) +
                (0.000345372 * (_temperature * _temperature * _humidity)) -
                (0.000814971 * (_temperature * _humidity * _humidity)) +
                (0.0000102102 * (_temperature * _temperature * _humidity * _humidity)) -
                (0.000038646 * (_temperature * _temperature * _temperature)) +
                (0.0000291583 * (_humidity * _humidity * _humidity)) +
                (0.00000142721 * (_temperature * _temperature * _temperature * _humidity)) +
                (0.000000197483 * (_temperature * _humidity * _humidity * _humidity)) -
                (0.0000000218429 * (_temperature * _temperature * _temperature * _humidity * _humidity)) +
                (0.000000000843296 * (_temperature * _temperature * _humidity * _humidity * _humidity))) -
                (0.0000000000481975
                        * (_temperature * _temperature * _temperature * _humidity * _humidity * _humidity)));
    }

}
