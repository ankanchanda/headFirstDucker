# The Observer Pattern

### The weather monitoring application overview
There are three players in the system:
- Weather Station(physical device that acquires the actual weather data)
- WeatherData object(tracks the data coming from the weather station and updates the display)
- The display device which shows users the current weather conditions

### Objective of Weather-O-Rama
Weather-O-Rama has a Weather Station which contains
- Humidity Sensor Device
- Temperature Sensor Device
- Pressure Sensor Device

### What we implement
WeatherData object which pulls data from Weather Station and shows the data in any display device.

WeatherData object updates its displayes for the three different display elements:
- Current Conditions
    - Temperature
    - Humidity
    - Pressure
- Weather Statistics
- Forecast

### Unpacking the WeatherData
WeatherData
- getTemparature()
- getHumidity()
- getPressure()
- measurementsChanged() [gets called whenever the weather measurements have been updated]

Job is to implement the measurementsChanged() so that it updates the three displays for current conditions, weather stats and forecast

### Things to keep in mind
- These displays must be updated each time WeatherData has new measurements.
- The system must be expandable — other developers can create new custom display elements and users can add or remove as many display elements as they want to the application. 

### The observer Pattern
Publishers + Subscribers = Observer Pattern

- we call the publisher, the SUBJECT
- the subscribers the OBSERVERS

The Observer Pattern defines a one-to-many dependency between objects so that when
one object changes state, all of its dependents are notified and updated automatically.