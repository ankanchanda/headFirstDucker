package ch2.somecode.displays;

import ch2.somecode.observer.Observer;
import ch2.somecode.subject.Subject;

public class CurrentConditionsDisplay implements DisplayElement, Observer{

    private Subject _weatherData;
    private float _temparature;
    private float _humidity;

    public CurrentConditionsDisplay(Subject weatherData) {
        this._weatherData = weatherData;
        this._weatherData.registerObserver(this);
    }

    @Override
    public void update(float temparature, float humidity, float pressure) {
        this._temparature = temparature;
        this._humidity = humidity;
        display();
    }

    @Override
    public void display() {
        System.out.println("Current Conditions: " + 
            _temparature + "F degrees and " + _humidity + "% humidity");
    }
    
}
