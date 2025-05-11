package ch2.someCode;

import ch2.someCode.displays.CurrentConditionsDisplay;
import ch2.someCode.displays.DisplayElement;
import ch2.someCode.displays.HeatIndexDisplay;
import ch2.someCode.displays.StatisticDisplay;
import ch2.someCode.subject.WeatherData;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();

        DisplayElement _currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        DisplayElement _statisticDisplay = new StatisticDisplay(weatherData);
        DisplayElement _heatIndexDisplay = new HeatIndexDisplay(weatherData);

        weatherData.setMeasurements(80f, 65f, 30.4f);
        weatherData.setMeasurements(82f, 68f, 26.2f);
        weatherData.setMeasurements(79f, 64f, 31.7f);
    }
}
