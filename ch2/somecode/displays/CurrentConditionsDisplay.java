package ch2.someCode.displays;

import ch2.someCode.observer.Observer;
import ch2.someCode.subject.WeatherData;

public class CurrentConditionsDisplay implements DisplayElement, Observer {

    private WeatherData _weatherData;
    private float _temperature;
    private float _humidity;
    private float _pressure;

    public CurrentConditionsDisplay(WeatherData weatherData) {
        this._weatherData = weatherData;
        this._weatherData.registerObserver(this);
    }

    // @Override
    // public void update(float temperature, float humidity, float pressure) {
    //     this._temperature = temperature;
    //     this._humidity = humidity;
    //     this._pressure = pressure;
    //     display();
    // }

    @Override
    public void update() {
        this._temperature = this._weatherData.getTemperature();
        this._humidity = this._weatherData.getHumidity();
        this._pressure = this._weatherData.getPressure();
        display();
    }

    @Override
    public void display() {
        System.out.println("Current Conditions: " +
                _temperature + "F degrees, " +
                _humidity + "% humidity" + ", and " +
                _pressure + "Hg atmospheric pressure");
    }

}
