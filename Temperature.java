//Write a Java program that accepts a list of weather
//data (e.g., temperature, humidity) and returns the
//number of days with temperatures within certain ranges
//(e.g., <0°C, 0-10°C, 10-20°C, etc.), and the average
//humidity for each temperature range.

import java.util.ArrayList;
import java.util.List;

public class Temperature {
	public static void main(String[] args) {
        List<WeatherEntry> weatherData = new ArrayList<>();
        weatherData.add(new WeatherEntry(5, 60)); 
        weatherData.add(new WeatherEntry(15, 50)); 
        weatherData.add(new WeatherEntry(25, 70)); 
        weatherData.add(new WeatherEntry(-5, 80)); 
        weatherData.add(new WeatherEntry(10, 65)); 
        weatherData.add(new WeatherEntry(20, 55)); 
        weatherData.add(new WeatherEntry(30, 75)); 
        
        int[] temperatureRanges = {-10, 0, 10, 20, 30, 40};

        int[] daysCount = new int[temperatureRanges.length + 1]; 
        double[] totalHumidity = new double[temperatureRanges.length + 1];
        int[] humidityCount = new int[temperatureRanges.length + 1];

        for (WeatherEntry entry : weatherData) {
            double temperature = entry.getTemperature();
            double humidity = entry.getHumidity();

            for (int i = 0; i < temperatureRanges.length; i++) {
                if (temperature < temperatureRanges[i]) {
                    daysCount[i]++;
                    totalHumidity[i] += humidity;
                    humidityCount[i]++;
                    break;
                }
            }
            daysCount[temperatureRanges.length]++;
            totalHumidity[temperatureRanges.length] += humidity;
            humidityCount[temperatureRanges.length]++;
        }

        System.out.println("Temperature Range\tDays Count\tAverage Humidity");
        for (int i = 0; i < temperatureRanges.length; i++) {
            double averageHumidity = humidityCount[i] == 0 ? 0 : totalHumidity[i] / humidityCount[i];
            System.out.printf("%s°C - %s°C\t\t\t%d\t\t%.2f%%\n",
                    i == 0 ? "< -10" : temperatureRanges[i - 1],
                    i == temperatureRanges.length - 1 ? ">= " + temperatureRanges[i] : temperatureRanges[i],
                    daysCount[i], averageHumidity);
        }
        double averageHumidity = humidityCount[temperatureRanges.length] == 0 ? 0 : totalHumidity[temperatureRanges.length] / humidityCount[temperatureRanges.length];
        System.out.printf(">= %s°C\t\t\t%d\t\t%.2f%%\n", temperatureRanges[temperatureRanges.length - 1], daysCount[temperatureRanges.length], averageHumidity);
    }
}

class WeatherEntry {
    private double temperature;
    private double humidity;

    public WeatherEntry(double temperature, double humidity) {
        this.temperature = temperature;
        this.humidity = humidity;
    }

    public double getTemperature() {
        return temperature;
    }

    public double getHumidity() {
        return humidity;
    }
}