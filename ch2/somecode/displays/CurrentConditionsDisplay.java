package ch2.somecode.displays;

import ch2.somecode.observer.Observer;
import ch2.somecode.subject.Subject;

public class CurrentConditionsDisplay implements DisplayElement, Observer {

    private Subject _weatherData;
    private float _temperature;
    private float _humidity;
    private float _pressure;

    public CurrentConditionsDisplay(Subject weatherData) {
        this._weatherData = weatherData;
        this._weatherData.registerObserver(this);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this._temperature = temperature;
        this._humidity = humidity;
        this._pressure = pressure;
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
