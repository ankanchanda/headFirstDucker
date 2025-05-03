package ch2.somecode.displays;

import ch2.somecode.observer.Observer;
import ch2.somecode.subject.Subject;

public class HeatIndexDisplay implements Observer, DisplayElement{

    private Subject _weatherData;
    private float _temparature;
    private float _humidity;
    private float _heatIndex;

    public HeatIndexDisplay(Subject weatherData) {
        this._weatherData = weatherData;
        this._weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Heat Index: " + _heatIndex);
    }

    @Override
    public void update(float temparature, float humidity, float pressure) {
        this._temparature = temparature;
        this._humidity = humidity;

        updateHeatIndex();
        display();
    }

    private void updateHeatIndex() {
        _heatIndex = (float)((16.923 + (0.185212 * _temparature) +
                            (5.37941 * _humidity) - (0.100254 * _temparature * _humidity) +
                            (0.00941695 * (_temparature * _temparature)) +
                            (0.00728898 * (_humidity * _humidity)) +
                            (0.000345372 * (_temparature * _temparature * _humidity)) -
                            (0.000814971 * (_temparature * _humidity * _humidity)) +
			                (0.0000102102 * (_temparature * _temparature * _humidity * _humidity)) -
                            (0.000038646 * (_temparature * _temparature * _temparature)) + 
                            (0.0000291583 *  (_humidity * _humidity * _humidity)) +
                            (0.00000142721 * (_temparature * _temparature * _temparature * _humidity)) + 
			                (0.000000197483 * (_temparature * _humidity * _humidity * _humidity)) -
                            (0.0000000218429 * (_temparature * _temparature * _temparature * _humidity * _humidity)) +
			                (0.000000000843296 * (_temparature * _temparature * _humidity * _humidity * _humidity))) -
			                (0.0000000000481975 * (_temparature * _temparature * _temparature * _humidity * _humidity * _humidity)));
    }
    
}
